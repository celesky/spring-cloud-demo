package com.example.feign.consumer.service;

import com.example.helloservice.api.HelloService;
import com.example.helloservice.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 业务降级处理
 * todo 会爆bean重复错误
 */

public class RefactorHelloServiceFallback implements HelloService {

    @Override
    public String hello4() {
        return null;
    }

    @Override
    public String hello5(@RequestParam("name") String name){
        return "hello5 method fallback";
    }

    @Override
    public User hello6(@RequestHeader("name") String name , @RequestHeader("age") Integer age) {
        return new User("hello6 fallback",0);
    }

    @Override
    public String hello7(@RequestBody User user) {
        return "hello7 method fallback";
    }
}
