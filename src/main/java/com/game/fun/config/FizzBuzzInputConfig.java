package com.game.fun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fizz.buzz")
@Data
public class FizzBuzzInputConfig {
    Integer startLimit = 1;
    Integer endLimit = 100;
    String sequenceType = "SIMPLE";
    String gameVersion = "V1";
}
