package com.website.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

// 直播间信息
@Data
@TableName("live_info")
public class LiveInfo implements Serializable {
    // 直播间id
    private Integer id;
    // 直播间名称
    private String name;
    // 直播间封面
    private String img;
    // 直播间热度
    private Integer hot;
    // 直播间标签
    private String tags;

}
