package com.example.feign.consumer.service;

import com.example.helloservice.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignHelloServiceFallback implements FeignHelloService{
    @Override
    public String hello() {
        return null;
    }

    @Override
    public String hello(@RequestParam("name") String name){
        return "hello5 method fallback";
    }
    @Override
    public User hello(@RequestHeader("name") String name , @RequestHeader("age") Integer age) {
        return new User("hello6 fallback",0);
    }
    @Override
    public String hello(@RequestBody User user) {
        return "hello7 method fallback";
    }
}
