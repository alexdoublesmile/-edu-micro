package edu.joyful.noteservice.config;

import edu.joyful.noteservice.exception.PersonFeignExceptionHandler;
import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PersonFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor feignAuthInterceptor(
            @Value("${person.service.username:default_user}") String username,
            @Value("${person.service.password:default_pass}") String password
    ) {
        return new BasicAuthRequestInterceptor(username, password);
    }

    @Bean
    public RequestInterceptor feignInterceptor(
            @Value("${person.service.username:default_user}") String username,
            @Value("${person.service.password:default_pass}") String password
    ) {
        return requestTemplate -> {
            requestTemplate.header("user", username);
            requestTemplate.header("password", password);
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new PersonFeignExceptionHandler();
    }
}
