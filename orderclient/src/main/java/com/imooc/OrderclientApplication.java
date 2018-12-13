package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderclientApplication.class, args);
	}

}

