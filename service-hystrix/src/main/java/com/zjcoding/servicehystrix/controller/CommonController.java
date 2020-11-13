package com.zjcoding.servicehystrix.controller;

import com.zjcoding.servicehystrix.service.FeignService;
import com.zjcoding.servicehystrix.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暂无描述
 *
 * @author ZhangJun
 * @date 10:20 2020/11/13
 */

@RestController
public class CommonController {

    @Autowired
    private FeignService feignService;

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/getPort/{type}")
    public String getPort(@PathVariable(value = "type") String type){
        if ("feign".equals(type)){
            return feignService.getPort();
        }
        return ribbonService.getPort();
    }

}
