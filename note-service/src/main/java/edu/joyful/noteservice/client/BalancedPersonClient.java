package edu.joyful.noteservice.client;


import edu.joyful.noteservice.domain.dto.PersonDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "person-service")
public interface BalancedPersonClient {

    @CircuitBreaker(name = "person-service", fallbackMethod = "getDefaultPerson")
    @GetMapping("/persons/{id}")
    PersonDto findPersonById(@PathVariable Long id);

    default PersonDto getDefaultPerson(Throwable exception) {
        return PersonDto.builder()
                .firstName("DEFAULT_FIRST_NAME")
                .lastName("DEFAULT_LAST_NAME")
                .build();
    }
}
