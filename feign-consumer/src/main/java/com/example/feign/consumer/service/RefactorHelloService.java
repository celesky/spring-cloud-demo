package com.example.feign.consumer.service;

import com.example.helloservice.api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 接口绑定服务,直接使用该接口可以远程rpc调用hello-service服务,继承来自api包的接口服务
 * fallback由自己consumer端提供
 */
@FeignClient(value = "hello-service",fallback = RefactorHelloServiceFallback.class)
public interface RefactorHelloService extends HelloService{



}


