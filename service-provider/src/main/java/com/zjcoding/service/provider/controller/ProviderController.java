package com.zjcoding.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * @author ZhangJun
 * @date 15:47 2020/10/24
 */

@RestController
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/getPort")
    public String getPort(){
        return "服务提供者-"+port;
    }

}