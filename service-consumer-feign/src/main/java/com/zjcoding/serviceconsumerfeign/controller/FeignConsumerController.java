package com.zjcoding.serviceconsumerfeign.controller;

import com.zjcoding.serviceconsumerfeign.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暂无描述
 *
 * @author ZhangJun
 * @date 17:34 2020/10/24
 */

@RestController
public class FeignConsumerController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/getProviderPort")
    public String getport(){
        return providerService.getPort();
    }

}
