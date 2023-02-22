package edu.joyful.noteservice.util;

import edu.joyful.noteservice.domain.dto.PersonDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PersonHelper {

    @Value("${default.comment}")
    private String DEFAULT_COMMENT;

    public PersonDto getDefaultPerson(Throwable exception) {
        log.error("Return default person according to {}", exception.getMessage());
        return PersonDto.builder()
                .firstName("DEFAULT_FIRST_NAME")
                .lastName("DEFAULT_LAST_NAME")
                .comment(DEFAULT_COMMENT)
                .build();
    }
}
