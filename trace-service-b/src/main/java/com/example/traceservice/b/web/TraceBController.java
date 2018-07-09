package com.example.traceservice.a.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceAController {

    private static Logger logger = LoggerFactory.getLogger(TraceAController.class);
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String trace() {
        logger.info("===call traceb.trace===");
        return restTemplate.getForEntity("http://trace-b/trace", String.class).getBody();
    }


}
