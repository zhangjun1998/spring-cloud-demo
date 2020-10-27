package com.zjcoding.serviceconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * 服务提供者
 *
 * @author ZhangJun
 * @date 17:35 2020/10/24
 */

@FeignClient(value = "service-provider", fallback = FallbackServiceImpl.class)
@Component
public interface ProviderService {

    @GetMapping(value = "/getPort")
    String getPort();

}
