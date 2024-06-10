package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudDemoAppApplication.class, args);
		
		System.out.println("===============================================Booted=====================================================");
	}

}
