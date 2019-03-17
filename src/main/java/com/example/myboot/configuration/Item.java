package com.example.myboot.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Getter
@Component
public class Item {
    @Value("${item.name}")
    private String name;
    private String id;
    private String color;
    @Value("${item.price}")
    private int price;

    public void test(){
        log.error(name+price);
    }
}
