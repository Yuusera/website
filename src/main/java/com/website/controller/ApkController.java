package com.website.controller;

import com.website.domain.ApkInfo;
import com.website.service.ApkService;
import com.website.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PostMapping("/upload")
    public Result<ApkInfo> uploadApk(@RequestParam("file") MultipartFile file) {
        log.info("上传文件:{}", now.format(formatter));
        try {
            return Result.success(apkService.uploadApk(file));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }

    @GetMapping("/download")
    public Result<ApkInfo> downloadApk() {
        log.info("下载文件:{}", now.format(formatter));
        return Result.success(apkService.downloadApk());
    }
}
