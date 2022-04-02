package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 让注册中心发现，并扫描到该服务
@EnableDiscoveryClient // 服务发现
public class DeptProvider_Config_8001 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptProvider_Config_8001.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("DeptProvider_Config_8001启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
