package com.example.myboot.web;

import com.example.myboot.model.Person;
import com.example.myboot.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
public class WebController {
    /*@RequestMapping(name="/getUser", method= RequestMethod.POST)
    public User getUser() {
        User user=new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }*/

    /**
     * hibernet  jsr  参数校验
     * @param person
     * @param bindingResult
     */
   @RequestMapping(name="/validPerson", method= RequestMethod.POST)
    public String validatePerson(@Valid Person person,BindingResult bindingResult){
        System.out.println("person:"+person);
        if(bindingResult.hasErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        return "";
    }



}
