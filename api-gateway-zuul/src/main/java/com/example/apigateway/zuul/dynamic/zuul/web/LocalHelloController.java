package com.example.apigateway.zuul.dynamic.zuul.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalHelloController {
    @RequestMapping("/local/hello")
    public String hello(){
        return "hello world , this is from local";
    }
}
