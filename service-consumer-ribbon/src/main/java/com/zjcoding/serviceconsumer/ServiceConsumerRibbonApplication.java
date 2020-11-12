package com.zjcoding.serviceconsumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerRibbonApplication.class, args);
	}

	/**
	 * 注入RestTemplate，用于简化Http请求
	 * LoadBalanced注解用于开启restTemplate的负载均衡功能
	 *
	 * @date 14:39 2020/11/12
	 * @Param []
	 * @return org.springframework.web.client.RestTemplate
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/**
	 * 代码方式全局配置负载均衡策略为轮询
	 * 这种全局配置会覆盖指定服务的配置？
	 *
	 * @date 15:29 2020/11/12
	 * @Param []
	 * @return com.netflix.loadbalancer.IRule
	 */
	@Bean
	public IRule loadBananaceRule(){
		return new RoundRobinRule();
	}


}
