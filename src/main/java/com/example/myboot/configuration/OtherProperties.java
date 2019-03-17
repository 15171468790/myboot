package com.example.myboot.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "other")
@PropertySource("classpath:resource/application.properties")
public class OtherProperties {
    private String title;
    private String blog;
}
