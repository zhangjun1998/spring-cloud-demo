package com.zjcoding.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon，集成RestTemplate，@LoadBalanced注解声明客户端负载均衡
 *
 * @author ZhangJun
 * @date 16:32 2020/10/24
 */

@RestController
public class RibbonConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProviderPort")
    public String getPort(){
        return restTemplate.getForObject("http://service-provider/getPort",String.class);
    }


}
