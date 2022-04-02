package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 服务端启动类，可以接收别人注册进来
@SpringBootApplication
public class EurekaServer_config_7001 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(EurekaServer_config_7001.class,args);
            System.out.println("启动之后，访问页面：http://localhost:7001/");
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
