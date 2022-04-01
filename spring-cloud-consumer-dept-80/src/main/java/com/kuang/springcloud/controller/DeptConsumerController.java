package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    // 消费者不应该有service层

    /**
     * RestTemplate，可以提供多种便捷访问远程http服务的方法
     * 是一种简单的RestFul服务
     */
    @Autowired
    private RestTemplate restTemplate;

    // 单机
    // private static final String REST_URL_PREFIX = "http://localhost:8001";

    // 负载均衡：使用LB的时候，地址是一个变量
//    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDER-DEPT";
    private static final String REST_URL_PREFIX = "http://spring-cloud-provider-dept";

    @RequestMapping("/consumer/dept/add")
    public Boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        System.out.println(restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class));
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

}
