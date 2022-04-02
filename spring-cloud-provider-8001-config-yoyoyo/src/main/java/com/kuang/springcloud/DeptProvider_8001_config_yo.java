package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 让注册中心发现，并扫描到该服务
@EnableDiscoveryClient // 服务发现
public class DeptProvider_8001_config_yo {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptProvider_8001_config_yo.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("DeptProvider_8001_config_yo启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
