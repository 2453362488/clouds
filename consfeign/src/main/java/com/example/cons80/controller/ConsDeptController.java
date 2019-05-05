package com.example.cons80.controller;

import com.example.api.model.Dept;
import com.example.api.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsDeptController {

    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://PROE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/cons/dept/add")
    public boolean add(Dept dept) {
        //    return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
        return service.add(dept);
    }

    @RequestMapping(value = "/cons/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        //    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return service.get(id);
    }

    @RequestMapping(value = "/cons/dept/list")
    public List<Dept> list() {
        //    return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
        return service.list();
    }

    @RequestMapping(value = "/cons/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
