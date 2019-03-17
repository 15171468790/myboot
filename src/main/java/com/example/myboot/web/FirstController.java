package com.example.myboot.web;

import com.example.myboot.common.MyThredLocal;
import com.example.myboot.configuration.Item;
import com.example.myboot.configuration.NeoProperties;
import com.example.myboot.configuration.OtherProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/")
public class FirstController {

    @Autowired
    private Item item;

    @Resource
    private NeoProperties neoProperties;

    @Resource
    private OtherProperties otherProperties;

    @RequestMapping("/test")
    public String test(){
        System.out.println("wgs");
        return "hello world";
    }

    @RequestMapping("/test1")
    public String test1(String name){
        System.out.println("wgs");
        return "hello world234"+name;
    }

    @RequestMapping(value="get/{name}", method= RequestMethod.GET)
    public String get(@PathVariable String name) {
        System.out.println("请求路径："+ MyThredLocal.getValue());
        item.test();
        System.out.println(neoProperties);
        System.out.println(otherProperties);
        return name;
    }

    @Test
    public void hello(){
        System.out.println("hello world");
    }
}
