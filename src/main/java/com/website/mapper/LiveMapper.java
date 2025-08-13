package com.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.LiveInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveMapper extends BaseMapper<LiveInfo> {
}
