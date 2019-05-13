package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/getHello")
    public String getHello(){
        return "hello";
    }

    @RequestMapping("/success")
    public String success(){
        return "/html/test.html";
    }

}
