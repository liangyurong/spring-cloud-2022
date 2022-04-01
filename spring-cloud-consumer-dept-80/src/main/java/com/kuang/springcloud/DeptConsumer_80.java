package com.kuang.springcloud;

import com.kuang.myrule.KuangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// ribbon和eureka整合之后，客户端可以直接调用，不用关心ip地址和端口号
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // 忽略数据库配置
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "spring-cloud-provider-dept",configuration = KuangRule.class) // eureka客户端 , 启动微服务的时候，就会自动去加在KuangRule.class
public class DeptConsumer_80 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptConsumer_80.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

}
