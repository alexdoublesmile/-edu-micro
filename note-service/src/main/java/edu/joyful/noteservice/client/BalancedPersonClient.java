package edu.joyful.noteservice.client;


import edu.joyful.noteservice.config.PersonFeignConfig;
import edu.joyful.noteservice.domain.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "person-service",
        configuration = PersonFeignConfig.class,
        fallback = PersonFeignFallback.class
)
public interface BalancedPersonClient {

    @GetMapping("/persons/{id}")
    PersonDto findPersonById(@PathVariable Long id);
}
