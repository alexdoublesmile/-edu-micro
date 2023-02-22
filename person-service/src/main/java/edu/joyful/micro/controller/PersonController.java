package edu.joyful.micro.controller;

import edu.joyful.micro.domain.Person;
import edu.joyful.micro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private int DELAY = 500;
    private boolean isFailed;

    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> findPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id) {
        log.info("Try request to DB for id={}", id);
        isFailed = !isFailed;

        if (isFailed) {
            log.info("Failed request for id={}", id);


            log.info("Delaying for {}ms", DELAY += 500);
            Thread.sleep(DELAY);

            log.info("Fall down :(");
            throw new RuntimeException();
        } else {
            log.info("Success request for id={}", id);
            return personRepository.findById(id).orElseThrow();
        }
    }
}
