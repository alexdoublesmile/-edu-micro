package edu.joyful.noteservice.domain.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonDto {
    String firstName;
    String lastName;
}
