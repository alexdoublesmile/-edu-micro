package edu.joyful.noteservice.client;

import edu.joyful.noteservice.domain.dto.PersonDto;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
@RequiredArgsConstructor
public class ManualPersonClient {
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;

//    @Retry(name = "person-service")
//    @TimeLimiter(name = "person-service")
//    @RateLimiter(name = "person-service")
//    @Bulkhead(name = "person-service")
//    @CircuitBreaker(name = "person-service")
    public PersonDto getPersonById(Long personId) {
        final ServiceInstance personInstance = discoveryClient.getInstances("person-service").get(0);
        final String serviceUrl = personInstance.getUri() + "/persons/{personId}";

        return circuitBreakerFactory.create("person-service")
                .run(() -> restTemplate.getForObject(serviceUrl, PersonDto.class, personId));
//        return restTemplate.getForObject(serviceUrl, PersonDto.class, personId);
    }
}
