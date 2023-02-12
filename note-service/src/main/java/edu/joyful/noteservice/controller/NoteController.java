package edu.joyful.noteservice.controller;

import edu.joyful.noteservice.domain.Note;
import edu.joyful.noteservice.domain.dto.NoteDto;
import edu.joyful.noteservice.repository.NoteRepository;
import edu.joyful.noteservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository noteRepository;
    private final NoteService noteService;

    @PostMapping
    public Note createPerson(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping
    public List<NoteDto> findAll() {
        return noteService.findAllWithPersons();
    }

    @GetMapping("/{personId}")
    public List<NoteDto> findAllWithPerson(@PathVariable Long personId) {
        return noteService.findAllWithPerson(personId);
    }
}
