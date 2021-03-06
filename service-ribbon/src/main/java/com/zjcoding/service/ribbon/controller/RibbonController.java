package com.zjcoding.service.ribbon.controller;

import com.zjcoding.service.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ribbon，集成RestTemplate，@LoadBalanced注解声明客户端负载均衡
 *
 * @author ZhangJun
 * @date 16:32 2020/10/24
 */

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    /**
     * 问题：映射路径为什么不能和其它服务路径相同
     *
     * @author ZhangJun
     * @date 11:23 2020/10/27
     * @Param []
     * @return java.lang.String
     */
    @GetMapping("/getPort")
    public String getPort(){
        return ribbonService.getPort();
    }

}
