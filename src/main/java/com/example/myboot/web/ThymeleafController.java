package com.example.myboot.web;

import com.example.myboot.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * thymeleaf模板测试类,成功
 */
@Controller
@RequestMapping("/")
public class ThymeleafController {
    @RequestMapping(value = "/thymeLeaf",method = RequestMethod.GET )
    public String thymeLeaf(ModelMap map, HttpServletRequest request){
    map.addAttribute("message","whant  cam t do fro you");
    map.addAttribute("flag","yes");
    map.addAttribute("type","s");
    map.addAttribute("img","http://nanning.china.com.cn/images/attachement/jpg/site413/20170401/b8aeedd3d2411a49a73523.jpg");
        List<User> userList = new ArrayList<>();
        User user =new User();
        user.setPass("pass");
        user.setName("name");
        user.setAge(100);
        user.setDate(new Date());
        userList.add(user);
        User user1 =new User();
        user1.setPass("pass");
        user1.setName("name");
        user1.setAge(100);
        user1.setDate(new Date());
        userList.add(user1);
        map.addAttribute("list",userList);


        request.setAttribute("request","i am request");
        request.getSession().setAttribute("session","i am session");



        map.addAttribute("userName", "neo");
        map.addAttribute("users", userList);
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "thymeleaf";
    }

    /**
     * 实现layout布局
     * @return
     */
    @RequestMapping(value = "/indexlayout",method = RequestMethod.GET )
    public String index(){
        return "layout";
    }
}
