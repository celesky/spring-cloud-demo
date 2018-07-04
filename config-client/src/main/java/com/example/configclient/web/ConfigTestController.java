package com.example.configclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigTestController {

    /**
     * 通过value注解注入配置参数
     */
    @Value("${mysql}")
    private String mysql;


    /**
     * 通过env对象获取配置信息
     */
//    @Autowired
//    private Environment env;

    @RequestMapping("/getMysql1")
    public String getMysql(){
        return this.mysql;
    }



//    @RequestMapping("/getMysql2")
//    public String getMysql2(){
//        return env.getName();
//    }




}
