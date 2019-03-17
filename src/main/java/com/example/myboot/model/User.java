package com.example.myboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * user用户类
 */
@Slf4j
@ToString
@Setter
@Getter
public class User {
    private String name;
    private int age;
    private String pass;
    private Date date;
    //setter、getter省略
}