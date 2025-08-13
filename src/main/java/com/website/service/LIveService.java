package com.website.service;

import com.website.domain.LiveInfo;

import java.util.List;

public interface LIveService {
    // 获取直播列表
    public List<LiveInfo> getLiveList();
}
