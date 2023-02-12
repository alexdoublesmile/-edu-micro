package edu.joyful.micro.service;

import edu.joyful.micro.domain.dto.PersonDto;
import edu.joyful.micro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDto> findPersonWithNotes(Long personId) {
        return null;
    }
}
