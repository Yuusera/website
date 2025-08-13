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
                        .orderByAsc("hot")
        );
    }
}
