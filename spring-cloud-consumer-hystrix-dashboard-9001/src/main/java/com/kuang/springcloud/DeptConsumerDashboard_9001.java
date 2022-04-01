package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 忽略数据库配置
@SpringBootApplication
@EnableHystrixDashboard // 开启监控
public class DeptConsumerDashboard_9001 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptConsumerDashboard_9001.class,args);
            System.out.println("启动之后，访问监控：http://localhost:9001/hystrix");
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
