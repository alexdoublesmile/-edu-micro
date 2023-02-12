package edu.joyful.micro.service;

import edu.joyful.micro.client.NotesClient;
import edu.joyful.micro.domain.Person;
import edu.joyful.micro.domain.dto.NoteDto;
import edu.joyful.micro.domain.dto.PersonDto;
import edu.joyful.micro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final NotesClient notesClient;

    public PersonDto findPersonWithNotes(Long personId) {
        final Person personFromDB = personRepository.findById(personId).orElseThrow();

        final List<NoteDto> notesFromNotesService = notesClient.getNotesByPersonId(personId);

        return PersonDto.builder()
                .firstName(personFromDB.getFirstName())
                .lastName(personFromDB.getLastName())
                .notes(notesFromNotesService)
                .build();
    }
}
