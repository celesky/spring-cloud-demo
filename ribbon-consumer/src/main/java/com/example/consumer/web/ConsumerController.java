package com.example.consumer.web;

import com.example.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    /**
     * 测试消费者
     */
    @RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        //调用provider端提供的服务 通过ribbon负载均衡
        return consumerService.consumerInvoke();
    }
}
