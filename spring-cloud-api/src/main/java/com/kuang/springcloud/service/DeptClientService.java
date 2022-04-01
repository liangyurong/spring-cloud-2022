package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 定义Feign客户端，做负载均衡
 */
@FeignClient(value = "spring-cloud-provider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class) // value里面是微服务名称，fallbackFactory是与服务降级类产生联系
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> queryAll();

    @PostMapping("/dept/add")
    Boolean addDept(@RequestBody Dept dept);



}
