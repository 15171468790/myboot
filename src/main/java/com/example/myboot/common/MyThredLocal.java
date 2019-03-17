package com.example.myboot.common;
/**
 * 存储不同线程的局部变量，线程封闭，线程安全
 */

import com.example.myboot.model.User;

public class MyThredLocal {

    private final static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    //set值
    public static void setValue(User user){
        userThreadLocal.set(user);
    }
    //get值
    public static User getValue(){
        return userThreadLocal.get();
    }
    //remove移除
    public static void remove(){
        userThreadLocal.remove();
    }

}
