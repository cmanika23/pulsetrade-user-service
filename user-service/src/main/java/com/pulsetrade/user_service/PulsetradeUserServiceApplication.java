package com.pulsetrade.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pulsetrade.user_service")
public class PulsetradeUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulsetradeUserServiceApplication.class, args);
	}

}
