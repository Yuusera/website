package com.website.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 临时链接获取
 *
 * @date 2025/8/20
 * @time 10:08
 */
@Data
@TableName("app")
public class AppInfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("android")
    private String appAndroidUrl;
    @TableField("ios")
    private String appIosUrl;
    private String createTime;
}
