package com.website.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class TimeLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimeLogAspect.class);

    @Around("@annotation(timeLog)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, TimeLog timeLog) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 获取方法名
        String methodName = method.getName();

        // 获取自定义消息，如果没有设置则使用方法名
        String logMessage = timeLog.value().isEmpty() ? methodName : timeLog.value();

        // 记录开始时间
        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        logger.info("调用目标: {}, 调用时间: {}", logMessage, startTime);

        // 使用StopWatch来测量执行时间
        // StopWatch stopWatch = new StopWatch();
        // stopWatch.start();
        try {
            // 执行目标方法
            Object result = joinPoint.proceed();

            // stopWatch.stop();
            String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            logger.info("调用目标: {}, 结束时间: {}",
                    logMessage, endTime);

            return result;
        } catch (Exception e) {
            // stopWatch.stop();
            String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            logger.error("执行失败: {}, 调用时间: {}, 异常: {}",
                    logMessage, endTime, e.getMessage());
            throw e;
        }
    }
}