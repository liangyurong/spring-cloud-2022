package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.kuang.springcloud")
@EnableEurekaClient // ribbon和eureka整合之后，客户端可以直接调用，不用关心ip地址和端口号
@EnableFeignClients(basePackages = {"com.kuang.springcloud"} )        // 启用feign客户端
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 忽略数据库配置
public class FeignDeptConsumer_9090 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(FeignDeptConsumer_9090.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
