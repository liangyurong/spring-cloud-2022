package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  提供restful服务
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept addDept(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/list")
    public List<Dept> queryAll(){
        System.out.println(deptService.queryAll());
        return deptService.queryAll();
    }

    // 注册进来的一些微服务，获取到一些消息
    @GetMapping("/discovery")
    public Object Discovery(){

        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discoverys: "+services);

        // 得到一个具体的微服务信息: 通过具体的微服务id，也就是配置文件的application.name
        List<ServiceInstance> instances = client.getInstances("spring-cloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println("instance信息：=================");
            System.out.println(instance.getHost()+" "+instance.getPort()+" "+instance.getUri()+" "+instance.getInstanceId());
        }

        return this.client;

    }

}
