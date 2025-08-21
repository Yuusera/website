package com.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.website.domain.LiveInfo;
import com.website.mapper.LiveMapper;
import com.website.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl implements LiveService {

    @Autowired
    private LiveMapper liveMapper;

    @Override
    public List<LiveInfo> getLive() {
        return liveMapper.selectList(
                new LambdaQueryWrapper<LiveInfo>()
                        .orderByDesc(LiveInfo::getSort)
        );
    }


    @Override
    public boolean addLive(LiveInfo liveInfo) {
        return liveMapper.insert(liveInfo) > 0 ? true : false;
    }

    @Override
    public boolean delLive(int id) {
        return liveMapper.deleteById(id) > 0 ? true : false;
    }

    @Override
    public boolean updateLive(LiveInfo liveInfo) {
        return liveMapper.updateById(liveInfo) > 0 ? true : false;
    }
}
