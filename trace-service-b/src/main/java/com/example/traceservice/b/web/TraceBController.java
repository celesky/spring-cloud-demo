package com.example.traceservice.b.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceBController {

    private static Logger logger = LoggerFactory.getLogger(TraceBController.class);


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String trace() {
        logger.info("===call trace a service===");
        return "this is come from TraceB service";
    }


}
