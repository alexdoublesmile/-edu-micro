package edu.joyful.micro.domain.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PersonDto {
    String firstName;
    String lastName;
    List<NoteDto> notes;
}
