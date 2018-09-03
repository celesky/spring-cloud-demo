package com.example.helloservice.web;

import com.example.helloservice.api.HelloService;
import com.example.helloservice.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暴露rpc服务接口
 * 通过互相继承接口耦合
 */
@RestController
public class RefactorHelloController implements HelloService{
    @Override
    public String hello4() {
        return "hello world Refactor \n ";
    }

    @Override
    public String hello5(@RequestParam("name") String name) {
        return "hello5 ! "+name;
    }

    @Override
    public User hello6(@RequestHeader("name")  String name,@RequestHeader("age")  Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello7(@RequestBody User  user) {
        return "hello7:"+user.getName()+ " , "+user.getAge();
    }
}
