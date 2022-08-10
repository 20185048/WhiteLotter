package com.example.springwork.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springwork.pojo.User;
import com.example.springwork.mapper.UserMapper;
import com.example.springwork.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinyaxu
 * @since 2022-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public Map<String, Object> login(String username, String password) throws Exception {
        // 验证用户名和密码
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = this.getOne(wrapper);
        if(user == null) {
            throw new Exception("用户名或密码错误");
        }
        if(user.getDeleted() == 0) {
            throw new Exception("该用户已经失效,无法登录");
        }
        if(!passwordEncoder.matches(password,user.getPassword())) {
            throw new Exception("用户名或密码错误");
        }
        // 如果登录成功 获取到用户权限
//        List<UmsResource> resources = resourceService.getByUserId(user.getId());
//        Map<String, Object> split = split(resources);
        Map<String,Object> reslut = new HashMap<>();
//        reslut.put("front",split.get("front"));
//        String token = JWT.create().withClaim("username",username)
//                .withClaim("backurls",(List<String>)split.get("back"))
//                .sign(Algorithm.HMAC256("wangyu"));
        String token = JWT.create().withClaim("username",username).sign(Algorithm.HMAC256("jinyaxu"));
        reslut.put("token",token);
        return reslut;
    }
}
