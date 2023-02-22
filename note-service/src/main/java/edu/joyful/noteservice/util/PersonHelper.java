package edu.joyful.noteservice.util;

import edu.joyful.noteservice.domain.dto.PersonDto;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonHelper {
    public static PersonDto getDefaultPerson(Throwable exception) {
        log.error("Return default person according to {}", exception.getMessage());
        return PersonDto.builder()
                .firstName("DEFAULT_FIRST_NAME")
                .lastName("DEFAULT_LAST_NAME")
                .build();
    }
}
