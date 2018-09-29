package com.cheney.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    /**
     * RoundRobinRule轮询
     * RandomRule随机
     * RetryRule重试
     */
    @Bean
    public IRule myRule() {
        
        return new RetryRule(); //达到的目的，用我们重新选择的算法替代默认的
    }
}
