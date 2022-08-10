package com.example.springwork.controller;


import com.example.springwork.pojo.User;
import com.example.springwork.service.IUserService;
import com.example.springwork.util.ResultJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jinyaxu
 * @since 2022-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService userService;
    @GetMapping("/list")
    public List<User> getUserList(){
        return userService.list();
    }
    @PostMapping("/login")
    ResultJson login(String username, String password) throws Exception {
        return ResultJson.success(userService.login(username, password),"登录成功");
    }
}
