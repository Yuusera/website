package com.website.controller;

import com.website.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * ai测试模块
 *
 * @date 2025/8/16
 * @time 13:45
 */
@RestController
public class ChatController {

    @Autowired
    private ConsultantService consultantService;

    @RequestMapping(value = "/chat", produces = "text/html;charset=UTF-8")
    // public String chat(String message) {
    //     return consultantService.chat(message);
    // }
    public Flux<String> chat(String message) {
        return consultantService.chat(message);
    }


    // @Autowired
    // private OpenAiChatModel model;
    // @RequestMapping("/chat")
    // public String chat(String message) {
    //     String res = model.chat(message);
    //     return res;
    // }
}
