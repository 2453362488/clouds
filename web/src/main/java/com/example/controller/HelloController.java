package com.example.controller;

import com.example.util.UrlUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/getUser")
    @ResponseBody
    public JSONObject getUser(){
        String a = UrlUtil.sendGet("http://119.146.189.250:9011/zhlxqms/leaderWindowController.do?getDepartList");
        JSONObject json = JSONObject.fromObject(a);
        return json;
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<Map<String, Object>> getUserList(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "女");
        list.add(map);
        return list;
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
