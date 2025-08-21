package com.website.controller;

import com.website.domain.ApkInfo;
import com.website.util.TimeLog;
import com.website.service.ApkService;
import com.website.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @date 2025/8/16
 * @time 16:51
 */
@RestController
@RequestMapping("/apk")
@Slf4j
public class ApkController {

    @Autowired
    private ApkService apkService;

    @TimeLog("上传apk")
    @PostMapping("/upload")
    public Result<ApkInfo> uploadApk(@RequestParam("file") MultipartFile file) {
        try {
            return Result.success(apkService.uploadApk(file));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }

    @TimeLog("下载apk")
    @GetMapping("/download")
    public Result<ApkInfo> downloadApk() {
        return Result.success(apkService.downloadApk());
    }
}
