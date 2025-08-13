package com.website.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.website.domain.AppInfo;
import com.website.domain.NotsApp;
import com.website.mapper.AppMapper;
import com.website.mapper.notsAppMapper;
import com.website.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Override
    public AppInfo getLatestApk() {
        return appMapper.selectOne(
                new QueryWrapper<AppInfo>()
                        .eq("is_latest", 1)
        );
    }

    @Override
    public List<AppInfo> getAllApk() {
        return appMapper.selectList(null);
    }

    /**
     *
     *
     * @param testApp
     */

    @Autowired
    private notsAppMapper notsAppMapper;


    @Override
    @Transactional
    public boolean saveApp(NotsApp notsApp) {
        if (notsApp == null) {
            return false;
        }
        return notsAppMapper.insert(notsApp) > 0 ? true : false;
    }

    @Override
    public NotsApp getAppByTime() {
        return notsAppMapper.selectOne(
                new LambdaQueryWrapper<NotsApp>()
                        .orderByDesc(NotsApp::getCreateTime)
                        .last("limit 1")
        );
    }


}
