package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;


    @CacheResult
    @HystrixCommand(fallbackMethod = "consumerInvokeback",commandKey = "consumerInvoke" ,groupKey = "Ribbon-Consumer",threadPoolKey = "consumerInvokeThread")
    public String consumerInvoke(){
        //调用provider端提供的服务 通过ribbon负载均衡
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


    @CacheRemove(commandKey = "consumerInvoke")
    @HystrixCommand(fallbackMethod = "consumerInvokeback",commandKey = "consumerInvoke" ,groupKey = "Ribbon-Consumer",threadPoolKey = "consumerInvokeThread")
    public void update(){

    }


    @HystrixCommand
    public Future<String> consumerInvokeAsyn(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
            }

        };

    }
    public String consumerInvokeback(){
        return "consumerInvoke  error fallback";
    }
}
