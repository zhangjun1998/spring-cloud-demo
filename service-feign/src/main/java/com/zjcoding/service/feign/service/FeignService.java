package com.zjcoding.service.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务提供者
 * Feign注解用于创建Ribbon客户端，name表示请求的服务名
 * 方法签名需要与被调用服务的方法一致
 *
 * @author ZhangJun
 * @date 17:35 2020/10/24
 */

@FeignClient(name = "service-provider")
@Service
public interface FeignService {

    @GetMapping(value = "/getPort")
    String getPort();

}
