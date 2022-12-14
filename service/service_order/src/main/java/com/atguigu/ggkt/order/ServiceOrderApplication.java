package com.atguigu.ggkt.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.ggkt.order.mapper")
public class ServiceOrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceOrderApplication.class, args);
	}
}