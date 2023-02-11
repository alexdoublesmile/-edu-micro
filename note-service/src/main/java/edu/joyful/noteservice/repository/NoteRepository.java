package edu.joyful.noteservice.repository;

import edu.joyful.noteservice.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
