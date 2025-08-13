package com.website.controller;

import com.website.domain.AppInfo;
import com.website.domain.LiveInfo;
import com.website.domain.NotsApp;
import com.website.service.AppService;
import com.website.service.LIveService;
import com.website.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private LIveService lIveService;

    /**
     * 获取最新版本的信息
     */
    @GetMapping("/latest")
    public Result<AppInfo> getLatestInfo() {
        return Result.success(appService.getLatestApk());
    }


    /**
     * 获取全部的版本信息
     *
     * @return
     */
    @GetMapping("/all")
    public Result<List<AppInfo>> getAllInfo() {
        return Result.success(appService.getAllApk());
    }


    /**
     * 测试内容
     */

    /**
     * 添加链接
     */
    @PostMapping("save")
    public Result<String> save(@RequestBody NotsApp notsApp) {
        boolean app = appService.saveApp(notsApp);
        return Result.success(app ? "添加成功" : "添加失败");
    }

    /**
     * 获取链接
     */
    @GetMapping("/getInfo")
    public Result<NotsApp> getInfo() {
        return Result.success(appService.getAppByTime());
    }

    /**
     * 获取主播列表
     */
    @GetMapping("/getLive")
    private Result<List<LiveInfo>> getLive() {
        return Result.success(lIveService.getLiveList());
    }
}
