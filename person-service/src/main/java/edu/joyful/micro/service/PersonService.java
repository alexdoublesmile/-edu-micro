package edu.joyful.micro.service;

import edu.joyful.micro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
}
