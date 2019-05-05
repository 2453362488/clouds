package com.example.proe8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //本服务启动会自动注册进eureka服务中
@EnableDiscoveryClient      //服务发现
public class Proe8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Proe8001Application.class, args);
    }

}
