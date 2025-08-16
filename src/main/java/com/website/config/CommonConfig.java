package com.website.config;

import com.website.service.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @date 2025/8/16
 * @time 14:01
 */
// @Configuration
public class CommonConfig {


    // @Autowired
    private OpenAiChatModel model;

    // @Bean
    public ConsultantService consultantService() {
        return AiServices.builder(ConsultantService.class)
                .chatModel(model)
                .build();
    }
}
