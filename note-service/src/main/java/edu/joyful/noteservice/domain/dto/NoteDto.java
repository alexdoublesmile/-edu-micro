package edu.joyful.noteservice.domain.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NoteDto {
    Long id;
    String body;
    PersonDto personDto;
}
