package edu.joyful.noteservice.controller;

import edu.joyful.noteservice.domain.Note;
import edu.joyful.noteservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository noteRepository;

    @PostMapping
    public Note createPerson(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping
    public List<Note> getNoteByPersonId(@RequestParam Long personId) {
        return noteRepository.findAllByPersonId(personId);
    }
}
