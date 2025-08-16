package com.website.service;


import com.website.domain.NotsApp;


/**
 *  app内容
 */
public interface AppService {
    /**
     *
     */

    // 保存app
    boolean saveApp(NotsApp notsApp);
    // 获取app
    NotsApp getAppByTime();
}

