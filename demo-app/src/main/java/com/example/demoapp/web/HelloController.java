package com.example.demoapp.web;

import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.List;
import java.util.StringJoiner;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
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
        return "hello world \n"+servs;
    }
}
