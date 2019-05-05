package com.example.proe8003.controller;

import com.example.proe8003.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return true;
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return null;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        List<Dept> lists = new ArrayList<>();
        Dept dept = new Dept();
        dept.setName("8003");
        lists.add(dept);
        return lists;
        //   return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("************" + list);
        List<ServiceInstance> srvList = client.getInstances("PROE");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" +
                    element.getPort() + "\t" + element.getUri());
        }
        return this.client;
    }

}
