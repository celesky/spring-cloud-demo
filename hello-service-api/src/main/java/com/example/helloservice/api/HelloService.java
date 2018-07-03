package com.example.helloservice.api;

import com.example.helloservice.bean.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello4();

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    String hello5(@RequestParam("name") String name);

    @RequestMapping(value = "/hello6", method = RequestMethod.GET)
    User hello6(@RequestHeader("name") String name , @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello7",method = RequestMethod.POST)
    String hello7(@RequestBody User user);
}
