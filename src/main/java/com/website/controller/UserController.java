package com.website.controller;

import com.website.domain.UserInfo;
import com.website.service.UserService;
import com.website.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 用户
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public Result<List<UserInfo>> getUserInfo() {
        return Result.success(userService.getUserInfoList());
    }



}
