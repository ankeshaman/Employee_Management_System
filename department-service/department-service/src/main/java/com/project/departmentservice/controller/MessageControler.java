package com.project.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RefreshScope will force this spring bean(MessageController) to reload the config
//it will trigger the refresh event to reload the config
@RefreshScope
@RestController
public class MessageControler {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("message")
    public String message(){
        return message;
    }

}
