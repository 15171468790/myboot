package com.example.myboot.web;

import com.example.myboot.model.Massage;
import com.example.myboot.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 使用Rest风格
 */

@RestController
@RequestMapping("/")
public class MyRestController {

    @Autowired
    private RestService restService;

    @PutMapping("rest/{id}")
    public Massage update(@PathVariable String id){
        Massage massage = new Massage();
        massage.setCount("2222");
        massage.setName("你好啊");
        return massage;
    }
    @GetMapping("restget/{id}")
    public Massage getById(@PathVariable String id, ModelMap map){
        map.addAttribute("massage",restService.getById(id));
        Massage massage =restService.getById(id);
        return massage;
    }
    @GetMapping(value = "messages")
    public List<Massage> findAll(ModelMap map){
        map.addAttribute("list",restService.findAll());
        List<Massage> massageList=restService.findAll();
        return massageList;
    }
    @PostMapping("/message")
    public Massage save(Massage massage){
        Massage massage1 =restService.save(massage);
        massage1.setName("111");
        return massage1;
    }
    @DeleteMapping(value = "message1/{id}")
    public void delete(@PathVariable String id,ModelMap map){
        restService.delete(id);
        map.put("mgs","成功");
    }
}
