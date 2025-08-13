package com.website.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("app_info")
public class AppInfo implements Serializable {
    // id
    private Integer id;
    // app名称
    private String appName;
    // app版本
    private String version;
    // app描述
    private String description;
    // 是否最新
    private Integer isLatest;
    // app下载地址
    private String downloadUrl;
    // app大小
    private String fileSize;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
}
