package com.example.myboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.myboot.mysqlModel.User;

import java.util.List;

@Setter
@Getter
@ToString
public class Massage {
    private String name;
    private String count;
    private List<User> userList;
}
