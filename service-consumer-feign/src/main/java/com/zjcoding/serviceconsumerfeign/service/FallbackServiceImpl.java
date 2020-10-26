package com.zjcoding.serviceconsumerfeign.service;

import org.springframework.stereotype.Component;

/**
 * 降级
 *
 * @author ZhangJun
 * @date 17:57 2020/10/24
 */

@Component
public class FallbackServiceImpl implements ProviderService{

    @Override
    public String getPort() {
        return "sorry,service is not can be useable";
    }
}
