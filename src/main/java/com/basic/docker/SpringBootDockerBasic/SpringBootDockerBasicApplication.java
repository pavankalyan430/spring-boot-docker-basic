package com.basic.docker.SpringBootDockerBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerBasicApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello from Dockerized Spring Boot!";
	}
}
