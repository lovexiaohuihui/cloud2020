package com.bochao.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义实现负载均衡 实现类
 * */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问:" + next);
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
