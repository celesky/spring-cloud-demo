package com.example.helloservice.web;

import com.example.helloservice.bean.User;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String hello(){
        List<String> serviceList = client.getServices();
        String servs="";
        if(serviceList!=null){
            servs = Joiner.on(",").join(serviceList);
        }
        List<ServiceInstance> serviceInstance = client.getInstances("hello-service");
        if(serviceInstance!=null){
            serviceInstance.stream().forEach(e->{
                System.out.println("e = " + e.toString());
            });
        }
        int sleepTime = new Random().nextInt(2000);

        logger.info("sleepTime:"+sleepTime);
//        try {
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "hello world \n"+servs;
    }

    /**
     * 普通参数
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello1" , method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "hello1 ! "+name;
    }


    /**
     * 普通参数
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello2" , method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    /**
     * 普通参数
     * @return
     */
    @RequestMapping(value = "/hello3" , method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "hello3:"+user.getName()+ " , "+user.getAge();
    }



}
