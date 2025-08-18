package com.website.service;

import com.website.domain.ApkInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @date 2025/8/16
 * @time 16:00
 */
public interface ApkService {
    // 上传apk
    ApkInfo uploadApk(MultipartFile file);

    // 下载apk
    ApkInfo downloadApk();
}
