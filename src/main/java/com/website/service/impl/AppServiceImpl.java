package com.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.website.domain.AppInfo;
import com.website.mapper.AppMapper;
import com.website.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @date 2025/8/20
 * @time 10:11
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;

    @Override
    public boolean save(AppInfo appInfo) {
        return appMapper.insert(appInfo) > 0 ? true : false;
    }

    @Override
    public AppInfo getInfo() {
        return appMapper.selectOne(
                new LambdaQueryWrapper<AppInfo>()
                        .orderByDesc(AppInfo::getCreateTime)
                        .last("limit 1")
        );
    }
}
