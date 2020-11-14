package com.zjcoding.service.ribbon.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡策略
 *
 * @author ZhangJun
 * @date 15:53 2020/11/12
 */
public class MyLoadBanlanceRule extends AbstractLoadBalancerRule {

    public MyLoadBanlanceRule() {

    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(),key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        // ...自定义策略选择一个Server返回
        return null;
    }

}
