package com.devdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevdeskApplication.class, args);
		
		System.out.println("Project init success !");
	}

}
