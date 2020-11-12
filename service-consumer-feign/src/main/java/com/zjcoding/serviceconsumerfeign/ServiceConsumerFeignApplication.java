package com.zjcoding.serviceconsumerfeign;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ServiceConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerFeignApplication.class, args);
	}

	/**
	 * 设置负载均衡策略
	 *
	 * @date 16:45 2020/11/12
	 * @Param []
	 * @return com.netflix.loadbalancer.IRule
	 */
	@Bean
	public IRule loadBanlanceRule(){
		return new RandomRule();
	}

}
