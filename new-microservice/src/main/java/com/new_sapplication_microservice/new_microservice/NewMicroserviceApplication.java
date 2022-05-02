package com.new_sapplication_microservice.new_microservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class NewMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewMicroserviceApplication.class, args);
		log.info("Server started successfully on port: 8082 - http://localhost:8082");
	}

}
