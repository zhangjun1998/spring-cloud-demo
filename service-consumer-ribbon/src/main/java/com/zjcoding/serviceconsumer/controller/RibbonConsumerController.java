package com.zjcoding.serviceconsumer.controller;

import com.zjcoding.serviceconsumer.service.RibbonConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ribbon，集成RestTemplate，@LoadBalanced注解声明客户端负载均衡
 *
 * @author ZhangJun
 * @date 16:32 2020/10/24
 */

@RestController
public class RibbonConsumerController {

    @Autowired
    private RibbonConsumerService consumerService;

    @GetMapping("/getPort")
    public String getPort(){
        return consumerService.getPort();
    }


}
