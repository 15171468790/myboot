package com.example.myboot.repositoty;

import com.example.myboot.mysqlModel.User;

import java.util.List;

public interface UserRepository  {
    int save(User user);
    int update(User user);
    int delete(long id);
    List<User> findALL();
    User findById(long id);
}
