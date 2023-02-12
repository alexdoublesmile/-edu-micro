package edu.joyful.micro.service;

import edu.joyful.micro.domain.Person;
import edu.joyful.micro.domain.dto.PersonDto;
import edu.joyful.micro.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
//    private final DiscoveryClient discoveryClient;

    public PersonDto findPersonWithNotes(Long personId) {
        final Person personFromDB = personRepository.findById(personId).orElseThrow();

//        final List<ServiceInstance> notesInstances = discoveryClient.getInstances("notes");
//        final ServiceInstance notesInstance = notesInstances.get(0);
//        final String host = notesInstance.getHost();
//        final Integer port = notesInstance.getPort();
//        final URI notesUri = notesInstance.getUri();

        return PersonDto.builder()
                .firstName(personFromDB.getFirstName())
                .lastName(personFromDB.getLastName())
                .notes(notesFromNotesService)
                .build();
    }
}
