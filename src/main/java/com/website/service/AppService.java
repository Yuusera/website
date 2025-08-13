package com.website.service;

import com.website.domain.AppInfo;
import com.website.domain.NotsApp;


import java.util.List;

public interface AppService {
    // 获取当前正在使用的最新版app
    AppInfo getLatestApk();

    // 获取全部的app列表
    List<AppInfo> getAllApk();


    /**
     *
     */

    // 保存app
    boolean saveApp(NotsApp notsApp);
    // 获取app
    NotsApp getAppByTime();
}

