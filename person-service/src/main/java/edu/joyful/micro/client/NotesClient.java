package edu.joyful.micro.client;

import edu.joyful.micro.domain.dto.NoteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "notes")
public interface NotesClient {
    @GetMapping("/notes")
    List<NoteDto> getNotesByPersonId(Long personId);
}
