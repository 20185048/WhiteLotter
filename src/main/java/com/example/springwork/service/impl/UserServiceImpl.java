package com.example.springwork.service.impl;

import com.example.springwork.pojo.User;
import com.example.springwork.mapper.UserMapper;
import com.example.springwork.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
