package com.zjcoding.servicehystrix.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign集成Hystrix
 *
 * @author ZhangJun
 * @date 10:21 2020/11/13
 */

@Service
@FeignClient(name = "service-provider", fallbackFactory = FeignService.FeignFallBackServiceImpl.class)
public interface FeignService {

    @GetMapping("/getPort")
    String getPort();

    /**
     * 用于降级
     */
    @Component
    @Slf4j
    class FeignFallBackServiceImpl implements FallbackFactory<FeignService> {

        @Override
        public FeignService create(Throwable throwable) {
            return new FeignService() {
                @Override
                public String getPort() {
                    log.error("进入回退逻辑",throwable);
                    return "service-provider出错了...by feign";
                }
            };
        }

    }

}
