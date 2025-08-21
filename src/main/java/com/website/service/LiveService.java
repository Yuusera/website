package com.website.service;

import com.website.domain.LiveInfo;

import java.util.List;

/**
 * 主播相关内容
 */
public interface LiveService {
    // 获取直播列表
    List<LiveInfo> getLive();

    // 新增主播列表
    boolean addLive(LiveInfo liveInfo);

    // 删除主播列表
    boolean delLive(int id);

    // 修改主播列表
    boolean updateLive(LiveInfo liveInfo);

    // 查询主播列表
    // LiveInfo getLive(int id);
}
