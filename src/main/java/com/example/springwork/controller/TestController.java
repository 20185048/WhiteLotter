package com.example.springwork.controller;

import com.example.springwork.SpringworkApplication;
import com.example.springwork.pojo.User;
import com.example.springwork.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringworkApplication.class)
public class TestController {
    @Resource
    IUserService userService;
    @Test
    public void handler(){
        User user=new User();
        user.setNickname("小李子");
        user.setUsername("xiaolizi");
        user.setPassword("123456");
        userService.save(user);
    }
}
