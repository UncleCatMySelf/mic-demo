package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 剩余服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RemainingclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemainingclientApplication.class, args);
	}

}

