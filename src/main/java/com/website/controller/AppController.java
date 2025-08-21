package com.website.controller;

import com.website.domain.AppInfo;
import com.website.domain.LiveInfo;
import com.website.util.TimeLog;
import com.website.service.AppService;

import com.website.service.LiveService;
import com.website.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@Slf4j
public class AppController {

    @Autowired
    private LiveService liveService;
    @Autowired
    private AppService appService;


    /**
     * 获取主播列表
     */
    @TimeLog("获取主播列表")
    @GetMapping("/getLive")
    public Result<List<LiveInfo>> getLive() {
        return Result.success(liveService.getLive());
    }

    /**
     * 新增主播
     */
    @TimeLog("新增主播")
    @PostMapping("/addLive")
    public Result<String> addLive(@RequestBody LiveInfo liveInfo) {
        return Result.success(liveService.addLive(liveInfo) ? "添加成功" : "添加失败");
    }

    /**
     * 删除主播
     */
    @TimeLog("删除主播")
    @DeleteMapping("/delLive/{id}")
    public Result<String> delLive(@PathVariable("id") int id) {
        return Result.success(liveService.delLive(id) ? "删除成功" : "删除失败");
    }

    /**
     * 更新主播信息
     */
    @TimeLog("更新主播信息")
    @PostMapping("/updateLive")
    public Result<String> updateLive(@RequestBody LiveInfo liveInfo) {
        return Result.success(liveService.updateLive(liveInfo) ? "更新成功" : "更新失败");
    }

    /**
     * 暂用添加链接
     */
    @TimeLog("暂用添加链接")
    @PostMapping("save")
    public Result<String> save(@RequestBody AppInfo appInfo) {
        return Result.success(appService.save(appInfo) ? "添加成功" : "添加失败");
    }

    /**
     * 暂用获取链接
     */
    @TimeLog("暂用获取链接")
    @GetMapping("getInfo")
    public Result<AppInfo> getInfo() {
        return Result.success(appService.getInfo());
    }
}
