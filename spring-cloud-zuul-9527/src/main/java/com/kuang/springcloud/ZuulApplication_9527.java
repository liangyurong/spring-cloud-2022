package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 忽略数据库配置
@SpringBootApplication
@EnableZuulProxy // 开启Zuul代理
public class ZuulApplication_9527 {


    public static void main(String[] args) {
        try{
            SpringApplication.run(ZuulApplication_9527.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
