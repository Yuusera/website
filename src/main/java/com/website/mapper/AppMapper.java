package com.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.AppInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppMapper extends BaseMapper<AppInfo> {
}

