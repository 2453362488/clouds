package com.example.cons80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.cons80"})
@ComponentScan("com.example.cons80")
public class ConsfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsfeignApplication.class, args);
    }

}
