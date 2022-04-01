package com.kuang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该bean不能放在springcloud包。如果放了，将会被共享
 */
@Configuration
public class KuangRule {

    /**
     * 自定义负载均衡的5次算法
     *
     * ribbon默认是轮询算法
     *
     */
    @Bean
    public IRule myRule(){
        // return new KuangRandomRule(); // 自定义的负载均衡算法
        return new RoundRobinRule();     // ribbon的轮询算法
    }

}
