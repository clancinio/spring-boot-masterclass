package com.example.springbootmasterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootMasterclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMasterclassApplication.class, args);
	}

}
