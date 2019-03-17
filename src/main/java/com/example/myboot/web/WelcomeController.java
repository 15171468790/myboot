package com.example.myboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "hello world");
        return "welcome";
    }

    /**
     * 实现jsp  c标签显示
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/user")
    public String user(Map<String, Object> model, HttpServletRequest request) {
        model.put("username", "neo");
        model.put("salary", 666);
        request.getSession().setAttribute("count",6);


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        model.put("list",list);
        return "user";
    }
}
