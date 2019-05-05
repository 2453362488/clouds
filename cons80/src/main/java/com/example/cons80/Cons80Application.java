package com.example.cons80;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROE", configuration = MySelfRule.class)
public class Cons80Application {

    public static void main(String[] args) {
        SpringApplication.run(Cons80Application.class, args);
    }

}
