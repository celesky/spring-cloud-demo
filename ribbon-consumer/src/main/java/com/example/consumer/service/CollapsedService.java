package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 合并器使用 demo
 */
public class CollapsedService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCollapser(batchMethod = "findAll" , collapserProperties = {
            @HystrixProperty(name="timeDelayInMilliseconds",value = "100")
    })
    public String find(Long id){
        return null;
    }


    @HystrixCommand
    public List<String> findAll(List<Long> ids){
        return restTemplate.getForEntity("http://HELLO-SERVICE/index",List.class, StringUtils.join(ids,",")).getBody();
    }
}
