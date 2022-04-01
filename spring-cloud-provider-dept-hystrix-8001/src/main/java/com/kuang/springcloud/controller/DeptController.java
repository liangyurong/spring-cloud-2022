package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  提供restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable Long id){
        Dept dept = deptService.queryById(id);

        if(null == dept){
            // @HystrixCommand的作用在于，抛出异常之后，直接调用hystrixGet方法
            throw new RuntimeException("通过id找不到Dept");
        }

        return dept;
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("通过id找不到Dept")
                .setDbSource("null db");
    }


}
