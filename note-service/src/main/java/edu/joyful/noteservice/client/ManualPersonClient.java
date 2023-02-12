package edu.joyful.noteservice.client;

import edu.joyful.noteservice.domain.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
@RequiredArgsConstructor
public class ManualPersonClient {
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public PersonDto getPersonById(Long personId) {
        final ServiceInstance personInstance = discoveryClient.getInstances("persons").get(0);
        final String serviceUrl = personInstance.getUri() + "/persons/{personId}";
        return restTemplate.getForObject(serviceUrl, PersonDto.class, personId);
    }
}
