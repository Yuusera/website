package com.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.website.domain.LiveInfo;
import com.website.mapper.LiveMapper;
import com.website.service.LIveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LIveServiceImpl implements LIveService {

    @Autowired
    private LiveMapper liveMapper;

    @Override
    public List<LiveInfo> getLiveList() {
        return liveMapper.selectList(
                new QueryWrapper<LiveInfo>()
                        .orderByAsc("sort")
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
