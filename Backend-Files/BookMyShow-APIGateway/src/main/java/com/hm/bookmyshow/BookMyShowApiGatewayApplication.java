package com.hm.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookMyShowApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApiGatewayApplication.class, args);
	}

}
