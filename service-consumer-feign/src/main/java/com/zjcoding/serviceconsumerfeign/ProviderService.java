package com.zjcoding.serviceconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 暂无描述
 *
 * @author ZhangJun
 * @date 17:35 2020/10/24
 */

@FeignClient(value = "service-provider")
public interface ProviderService {

    @GetMapping(value = "/getPort")
    String getPort();

}
