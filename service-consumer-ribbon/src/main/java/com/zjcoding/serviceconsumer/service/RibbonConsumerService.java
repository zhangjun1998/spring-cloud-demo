package com.zjcoding.serviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 暂无描述
 *
 * @author ZhangJun
 * @date 10:36 2020/10/26
 */
@Service
public class RibbonConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    public String getPort(){
        // 使用服务名取代具体地址，方便进行负载均衡
        return restTemplate.getForObject("http://service-provider/getPort",String.class);
    }

}
