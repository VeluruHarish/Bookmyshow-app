package com.hm.Capstoneproject.gmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CapstoneprojectGmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneprojectGmailApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
}
