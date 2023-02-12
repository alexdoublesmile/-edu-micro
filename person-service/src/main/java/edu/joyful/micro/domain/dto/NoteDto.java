package edu.joyful.micro.domain.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NoteDto {
    Long id;
    String body;
}
