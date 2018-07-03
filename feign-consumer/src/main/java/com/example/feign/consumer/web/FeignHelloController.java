package com.example.feign.consumer.web;

import com.example.feign.consumer.service.FeignHelloService;
import com.example.feign.consumer.service.RefactorHelloService;
import com.example.helloservice.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHelloController {

    @Autowired
    FeignHelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    //测试消费者
    @RequestMapping(value="/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        //调用provider端提供的服务 通过ribbon负载均衡
        return helloService.hello();
    }


    /**
     *  测试消费者
     */

    @RequestMapping(value="/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){

        StringBuilder sb = new StringBuilder();
        sb.append("hello:").append(helloService.hello()).append("<br/>");
        sb.append("hello1:").append(helloService.hello("jack")).append("<br/>");
        sb.append("hello2:").append(helloService.hello("mark",22)).append("<br/>");
        sb.append("hello3:").append(helloService.hello(new User("paul",24))).append("<br/>");

        return sb.toString();
    }

    /**
     * 继承api包的方式 测试消费者
     */
    @RequestMapping(value="/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){

        StringBuilder sb = new StringBuilder();
        sb.append("hello4:").append(refactorHelloService.hello4()).append("<br/>");
        sb.append("hello5:").append(refactorHelloService.hello5("jack")).append("<br/>");
        sb.append("hello6:").append(refactorHelloService.hello6("mark",22)).append("<br/>");
        sb.append("hello7:").append(refactorHelloService.hello7(new User("paul",24))).append("<br/>");

        return sb.toString();
    }


}
