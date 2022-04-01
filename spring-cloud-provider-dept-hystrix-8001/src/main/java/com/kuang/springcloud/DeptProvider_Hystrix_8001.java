package com.kuang.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient // 让注册中心发现，并扫描到该服务
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 添加对熔断的支持
public class DeptProvider_Hystrix_8001 {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DeptProvider_Hystrix_8001.class,args);
        }catch (Exception e){
            System.out.println(" =========================== ");
            System.out.println("启动失败，异常信息：" + e.getMessage());
            System.out.println(" =========================== ");
        }
    }

    // 增加一个Servlet(监控)
    // 这段代码都是这么写的，不需要改
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream"); // 路径是http://localhost:9001/hystrix的页面提供的
        return  registrationBean;
    }

}
