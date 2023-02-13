package edu.joyful.noteservice.service;

import edu.joyful.noteservice.client.BalancedPersonClient;
import edu.joyful.noteservice.client.ManualPersonClient;
import edu.joyful.noteservice.domain.Note;
import edu.joyful.noteservice.domain.dto.NoteDto;
import edu.joyful.noteservice.domain.dto.PersonDto;
import edu.joyful.noteservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Log4j2
@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
//    private final ManualPersonClient personClient;
    private final BalancedPersonClient personClient;

    public List<NoteDto> findAllWithPerson(Long personId) {
        return noteRepository.findAllByPersonId(personId)
                .stream()
                .map(this::convertToDto)
                .collect(toList());
    }

    public List<NoteDto> findAllWithPersons() {
        return noteRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(toList());
    }

    private NoteDto convertToDto(Note note) {
        log.info("Try request to person-service for {}", note);
        PersonDto personDto = personClient.findPersonById(note.getPersonId());

        log.info("Success request to person-service for {}", note);
        return NoteDto.builder()
                .id(note.getId())
                .body(note.getBody())
                .personDto(personDto)
                .build();
    }
}
