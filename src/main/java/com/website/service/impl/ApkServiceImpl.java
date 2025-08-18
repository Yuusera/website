package com.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.website.domain.ApkInfo;
import com.website.mapper.ApkMapper;
import com.website.service.ApkService;
import com.website.util.Url;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;

/**
 *
 * @date 2025/8/16
 * @time 16:03
 */
@Slf4j
@Service
public class ApkServiceImpl implements ApkService {

    @Autowired
    private ApkMapper apkMapper;

    @SneakyThrows
    @Override
    public ApkInfo uploadApk(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String lowerCase = filename.toLowerCase();
        byte[] bytes = file.getBytes();
        // 检查文件是否为空
        if (file == null || file.isEmpty()) {
            throw new RemoteException("文件为空");
        }
        // 检测文件名是否正确
        if (filename.isEmpty() || filename == null) {
            throw new RemoteException("文件名无效");
        }
        // 检查文件内容是否为空
        if (bytes == null || bytes.length == 0) {
            throw new RemoteException("文件内容为空");
        }
        ApkInfo apkInfo = new ApkInfo();
        String md5 = DigestUtils.md5DigestAsHex(file.getInputStream());
        if (apkMapper.existsByMd5(md5)) {
            throw new RemoteException("文件已存在");
        }
        apkInfo.setMd5(md5);
        apkInfo.setAppIosUrl(Url.iosUrl);
        // 根据文件名区分类型
        if (lowerCase.endsWith(".apk")) {
            String filePath = saveFile(file, Url.androidUrl);
            apkInfo.setAppAndroidUrl(filePath);
        } else {
            throw new RemoteException("仅支持apk文件上传");
        }
        if (!apkMapper.insertApk(apkInfo)) {
            throw new RemoteException("文件上传失败");
        }
        return apkInfo;
    }


    @SneakyThrows
    public String saveFile(MultipartFile file, String targetPath) {
        Path path = Paths.get(targetPath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        String filePath = path + "/" + file.getOriginalFilename();
        Path target = Paths.get(filePath);
        Files.write(target, file.getBytes());
        return filePath;
    }

    @Override
    public ApkInfo downloadApk() {
        return apkMapper.selectOne(
                new LambdaQueryWrapper<ApkInfo>()
                        .orderByAsc(ApkInfo::getCreateTime)
                        .last("limit 1")
        );
    }
}
