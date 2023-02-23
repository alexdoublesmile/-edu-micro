package edu.joyful.noteservice.client;

import edu.joyful.noteservice.domain.dto.PersonDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class PersonFeignFallback implements BalancedPersonClient {

    @Value("${default.comment}")
    private String DEFAULT_COMMENT;

    @Override
    public PersonDto findPersonById(Long id) {
        return PersonDto.builder()
                .firstName("DEFAULT_FIRST_NAME")
                .lastName("DEFAULT_LAST_NAME")
                .comment(DEFAULT_COMMENT)
                .build();
    }
}
