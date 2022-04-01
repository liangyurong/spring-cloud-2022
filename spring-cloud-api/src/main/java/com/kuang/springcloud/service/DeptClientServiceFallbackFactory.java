package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

// 熔断降级。现在是想将整个DeptClientService类进行关闭
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    // 对一个类进行操作
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("客户端提供了降级的信息，现在这个服务已经被关闭")
                        .setDbSource("no db source");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
