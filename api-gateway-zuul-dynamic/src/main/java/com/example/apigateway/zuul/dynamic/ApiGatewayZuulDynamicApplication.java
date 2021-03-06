package com.example.apigateway.zuul.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 接入zuul网关,config动态配置,配置文件在git上
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayZuulDynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZuulDynamicApplication.class, args);
	}
}
