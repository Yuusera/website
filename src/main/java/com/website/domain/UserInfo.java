package com.website.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class UserInfo implements Serializable {
    // id
    private Integer id;
    // 姓名
    private String name;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 权限
    private Integer role;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 是否可用
    private Integer isAvailable;
}
