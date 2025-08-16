package com.website.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.ApkInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * apk文件
 *
 * @date 2025/8/16
 * @time 15:54
 */
@Mapper
public interface ApkMapper extends BaseMapper<ApkInfo> {
    // 添加apk
    @Insert("insert into apk(app_android_url, app_ios_url, md5) values(#{appAndroidUrl}, #{appIosUrl}, #{md5})")
    boolean insertApk(ApkInfo apkInfo);

    // 查询md5值是否有重复的
    @Select("select count(1) > 0 from apk where md5 = #{md5}")
    boolean existsByMd5(String md5);
}
