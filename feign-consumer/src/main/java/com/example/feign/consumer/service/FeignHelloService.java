package com.example.feign.consumer.service;

import com.example.helloservice.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@FeignClient(value = "hello-service",fallback = FeignHelloServiceFallback.class)
public interface FeignHelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @RequestMapping("/hello2")
    User hello(@RequestHeader("name") String name , @RequestHeader("age") Integer age);

    @RequestMapping("/hello3")
    String hello(@RequestBody User user);


}
