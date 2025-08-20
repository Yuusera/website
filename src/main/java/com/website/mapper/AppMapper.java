package com.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.AppInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @date 2025/8/20
 * @time 10:10
 */
@Mapper
public interface AppMapper extends BaseMapper<AppInfo> {
}
