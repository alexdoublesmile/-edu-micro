package edu.joyful.noteservice.service;

import edu.joyful.noteservice.client.BalancedPersonClient;
import edu.joyful.noteservice.domain.dto.PersonDto;
import edu.joyful.noteservice.util.PersonHelper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {
    //    private final ManualPersonClient personClient;
    private final BalancedPersonClient personClient;
    private final PersonHelper personHelper;

//    @CircuitBreaker(name = "person-service", fallbackMethod = "getDefaultPerson")
    public PersonDto getPersonDto(Long personId) {
        return personClient.findPersonById(personId);
    }

    private PersonDto getDefaultPerson(Throwable exception) {
        return personHelper.getDefaultPerson(exception);
    }
}
