package com.website.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("apk")
public class ApkInfo {
    // id
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 名字
    // private String apkName;
    // 安卓链接
    private String appAndroidUrl;
    // ios链接
    private String appIosUrl;
    // 创建时间
    private String createTime;
    // md5值
    private String md5;
}
