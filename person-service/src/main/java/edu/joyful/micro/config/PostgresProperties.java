package edu.joyful.micro.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("postgresql")
public class PostgresProperties {
    private String password;
}
