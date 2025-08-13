package com.website.service;

import com.website.domain.UserInfo;

import java.util.List;


public interface UserService {

    // 获取用户信息
    UserInfo getUserInfoById(int id);
    // 获取用户信息列表
    List<UserInfo> getUserInfoList();
}
