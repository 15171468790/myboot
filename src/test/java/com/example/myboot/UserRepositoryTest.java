package com.example.myboot;

import com.example.myboot.mysqlModel.User;
import com.example.myboot.repositoty.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user =new User("neo","123456",30);
        userRepository.save(user);
    }

    @Test
    public void testUpdate() {
        User user =new User("neo","123456",18);
        user.setId(1L);
        userRepository.update(user);
    }

    @Test
    public void testDetele() {
        userRepository.delete(1L);
    }

    @Test
    public void testQueryOne()  {
        User user=userRepository.findById(2L);
        System.out.println("user == "+user.toString());
    }

    @Test
    public void testQueryAll()  {
        List<User> users=userRepository.findALL();
        for (User user:users){
            System.out.println("user == "+user.toString());
        }
    }




}
