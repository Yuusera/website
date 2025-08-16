package com.website.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.website.domain.NotsApp;
import com.website.mapper.notsAppMapper;
import com.website.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppServiceImpl implements AppService {

    /**
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
