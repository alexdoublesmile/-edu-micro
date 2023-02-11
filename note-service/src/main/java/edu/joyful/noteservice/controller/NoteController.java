package edu.joyful.noteservice.controller;

import edu.joyful.noteservice.domain.Note;
import edu.joyful.noteservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository noteRepository;

    @GetMapping
    public List<Note> getNoteByPersonId(@RequestParam Long personId) {
        return noteRepository.findAllByPersonId(personId);
    }
}
