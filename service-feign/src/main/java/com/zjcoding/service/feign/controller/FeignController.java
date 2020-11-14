package com.zjcoding.service.feign.controller;

import com.zjcoding.service.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 与Ribbon作用类似，请求映射更加简单，默认提供负载均衡、熔断器
 *
 * @author ZhangJun
 * @date 17:34 2020/10/24
 */

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping("/getPort")
    public String getport(){
        return feignService.getPort();
    }

}
