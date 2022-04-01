package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 服务启动后，自动注册到Eureka中
@EnableDiscoveryClient // 服务发现
public class DeptProvider_8003 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptProvider_8003.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
