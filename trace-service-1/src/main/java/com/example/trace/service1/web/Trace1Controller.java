package com.example.trace.service1.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Trace1Controller {

    private static Logger logger = LoggerFactory.getLogger(Trace1Controller.class);

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "service1", method = RequestMethod.GET)
    public String service1() {
        return restTemplate.getForObject("http://trace-service-2/service2", String.class);
    }

}