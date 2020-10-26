package com.zjcoding.serviceconsumerfeign.controller;

import com.zjcoding.serviceconsumerfeign.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 与Ribbon作用类似，请求映射更加简单，默认提供负载均衡、熔断器
 *
 * @author ZhangJun
 * @date 17:34 2020/10/24
 */

@RestController
public class FeignConsumerController {

    @Qualifier("providerService")
    @Autowired
    ProviderService providerService;

    @GetMapping("/getProviderPort")
    public String getport(){
        return providerService.getPort();
    }

}
