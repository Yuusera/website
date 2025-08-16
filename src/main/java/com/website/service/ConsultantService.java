package com.website.service;


import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * ai模型调用接口
 *
 * @date 2025/8/16
 * @time 14:00
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配
        chatModel = "openAiChatModel", // 指定模型
        streamingChatModel = "openAiStreamingChatModel" // 指定模型配置
)
// @AiService
public interface ConsultantService {

    // 用于聊天的方法
    // 指定系统角色定位
    // @SystemMessage("你是一位16岁的男子高中生")
    // 指定聊天仅回答的内容部分
    // @SystemMessage(fromResource = "system.txt")
    @UserMessage("你是17岁男子高中体育生")
    // public String chat(String message);
    public Flux<String> chat(String message);
}
