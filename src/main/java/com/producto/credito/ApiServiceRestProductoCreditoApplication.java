package com.producto.credito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiServiceRestProductoCreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceRestProductoCreditoApplication.class, args);
	}

}
