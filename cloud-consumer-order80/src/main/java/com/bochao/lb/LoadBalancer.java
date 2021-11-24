package com.bochao.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义实现负载均衡 接口类
 * @author 吴军杰
 * */
public interface LoadBalancer {

    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
