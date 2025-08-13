package com.website.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("nots_app")
public class NotsApp implements Serializable {

    private String appAndroidUrl;
    private String appIosUrl;
    private String createTime;
}
