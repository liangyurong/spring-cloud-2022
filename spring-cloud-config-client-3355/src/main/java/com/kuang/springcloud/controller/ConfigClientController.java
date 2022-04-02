package com.kuang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServerName;
    @Value("${server.port}")
    private String port;

    // 测试能够读取到3344项目，进而读取到
    @GetMapping("/config")
    public String getConfig(){
        return applicationName+" "+eurekaServerName+" "+port;
    }

}
