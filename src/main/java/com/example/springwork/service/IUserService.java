package com.example.springwork.service;

import com.example.springwork.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jinyaxu
 * @since 2022-08-03
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(String username, String password) throws Exception;
}
