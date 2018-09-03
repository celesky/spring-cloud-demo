package com.example.trace.service2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trace2Controller {

    @RequestMapping(value = "service2", method = RequestMethod.GET)
    public String service2() {
        return "this is come from new trace-service-2";
    }

}
