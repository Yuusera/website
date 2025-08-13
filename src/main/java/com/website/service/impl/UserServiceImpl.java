package com.website.service.impl;

import com.website.domain.UserInfo;
import com.website.mapper.UserMapper;
import com.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserInfoById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        return userMapper.selectList(null);
    }
}
