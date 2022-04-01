package com.kuang.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class KuangRandomRule extends AbstractLoadBalancerRule {
    // 每个服务访问 5 次，换下一个服务
    // total=0 => 默认 0，如果等于 5 ，指向下一个服务节点
    // index=0 => 默认 0，如果 total 等于 5 ，index+1
    private int total=0;        //被调用的次数
    private int currentIndex=0; //当前谁在提供服务


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //获得存活的服务
            List<Server> allList = lb.getAllServers();//获得全部服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);//在区间内随机获得一个地址
//            server = upList.get(index);//从存活的列表中获得


            //=================================

            total++;
            if(total>5){
                total=0;
                currentIndex++;
            }
            if(currentIndex>=upList.size()) currentIndex=0;
            server = upList.get(currentIndex);

            //=================================

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}