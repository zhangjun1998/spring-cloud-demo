package com.zjcoding.servicehystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate+Ribbon集成Hystrix
 *
 * @author ZhangJun
 * @date 10:21 2020/11/13
 */
@Service
@Slf4j
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 也可以不指定降级方法，默认的降级方式是抛出异常
     *
     * @date 11:29 2020/11/13
     * @Param []
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "getPortError")
    public String getPort(){
        return restTemplate.getForObject("http://service-provider/getPort",String.class);
    }

    /**
     * 降级方法
     *
     * @date 10:56 2020/11/13
     * @Param []
     * @return java.lang.String
     */
    public String getPortError(Throwable throwable){
        log.error("进入回退逻辑",throwable);
        return "获取service-provider出错了...by ribbon";
    }

}
