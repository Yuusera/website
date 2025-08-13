package com.website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 指定域名
                .allowedOriginPatterns("*")  // 使用 allowedOriginPatterns 替代 allowedOrigins
                // 指定允许的请求方法
                .allowedMethods("*")
                // 指定允许的请求头
                .allowedHeaders("*")
                // 指定请求头暴露给前端
                .exposedHeaders("Authorization", "Content-Disposition"); // 暴露给客户端的响应头
        // .allowCredentials(true);// 允许携带凭证
        // .maxAge(3600);  // 预检请求的有效期，单位为秒
    }
}