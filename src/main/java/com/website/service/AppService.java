package com.website.service;

import com.website.domain.AppInfo;

/**
 *
 * @date 2025/8/20
 * @time 10:11
 */
public interface AppService {
    // 添加
    boolean save(AppInfo appInfo);
    // 获取
    AppInfo getInfo();
}
