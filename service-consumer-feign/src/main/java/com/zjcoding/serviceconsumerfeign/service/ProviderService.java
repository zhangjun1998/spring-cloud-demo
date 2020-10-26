package com.zjcoding.serviceconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务提供者
 *
 * @author ZhangJun
 * @date 17:35 2020/10/24
 */

@FeignClient(value = "service-provider", fallback = FallbackServiceImpl.class)
@Service
public interface ProviderService {

    @GetMapping(value = "/getPort")
    String getPort();

}
