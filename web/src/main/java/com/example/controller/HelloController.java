package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/getHello")
    @ResponseBody
    public String getHello(){
        return "hello";
    }

    @RequestMapping("/success")
    public String success(){
        return "/html/test.html";
    }

    @RequestMapping("/special")
    public String special(){
        return "special.html";
    }

    @RequestMapping("/quickSort")
    public String quickSort(){
        return "/quickSort.html";
    }

    @RequestMapping("/love")
    public String love(){
        return "love.html";
    }

}
