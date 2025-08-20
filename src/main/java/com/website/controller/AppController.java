package com.website.controller;

import com.website.domain.AppInfo;
import com.website.domain.LiveInfo;
import com.website.service.AppService;
import com.website.service.LIveService;
import com.website.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/app")
@Slf4j
public class AppController {

    @Autowired
    private LIveService lIveService;
    @Autowired
    private AppService appService;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取主播列表
     */
    @GetMapping("/getLive")
    private Result<List<LiveInfo>> getLive() {
        log.info("获取主播列表:{}", now.format(formatter));
        return Result.success(lIveService.getLiveList());
    }

    /**
     * 新增主播
     */
    @PostMapping("/addLive")
    public Result<String> addLive(@RequestBody LiveInfo liveInfo) {
        log.info("新增主播:{}", now.format(formatter));
        return Result.success(lIveService.addLive(liveInfo) ? "添加成功" : "添加失败");
    }

    /**
     * 删除主播
     */
    @DeleteMapping("/delLive/{id}")
    public Result<String> delLive(@PathVariable("id") int id) {
        log.info("删除主播:{}", now.format(formatter));
        return Result.success(lIveService.delLive(id) ? "删除成功" : "删除失败");
    }

    /**
     * 更新主播信息
     */
    @PostMapping("/updateLive")
    public Result<String> updateLive(@RequestBody LiveInfo liveInfo) {
        log.info("更新主播信息:{}", now.format(formatter));
        return Result.success(lIveService.updateLive(liveInfo) ? "更新成功" : "更新失败");
    }

    /**
     * 暂用添加链接
     */
    @PostMapping("save")
    public Result<String> save(@RequestBody AppInfo appInfo) {
        return Result.success(appService.save(appInfo) ? "添加成功" : "添加失败");
    }

    /**
     * 暂用获取链接
     */
    @GetMapping("getInfo")
    public Result<AppInfo> getInfo() {
        return Result.success(appService.getInfo());
    }
}
