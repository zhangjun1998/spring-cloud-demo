package com.zjcoding.serviceconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
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

    @HystrixCommand(fallbackMethod = "getPortError")
    public String getPort(){
        return restTemplate.getForObject("http://service-provider/getPort",String.class);
    }

    public String getPortError(){
        return "sorry,the ribbon service is not can be use";
    }

}
