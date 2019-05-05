package com.example.cons80.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于NetFlix Ribbon实现的一套客户端 负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public IRule myRule(){
     //   return new RandomRule(); // 用随机算法替换轮训算法
        return new RetryRule();
    }*/

}
