package com.example.springcloud.login.service.impl;

import com.example.springcloud.login.mapper.UserMapper;
import com.example.springcloud.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List selectAllUser(Map map) throws Exception {
        return userMapper.selectAll(map);
    }
}
