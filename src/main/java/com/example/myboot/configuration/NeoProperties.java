package com.example.myboot.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 配置类，
 * 比如说数据库配置类
 */
@Component
@ConfigurationProperties(prefix = "neo")
@Setter
@Getter
@ToString
public class NeoProperties {
    private String title;
    private String description;
}
