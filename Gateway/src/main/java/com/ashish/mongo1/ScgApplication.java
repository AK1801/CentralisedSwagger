package com.ashish.mongo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableScheduling
public class ScgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScgApplication.class, args);
	}

}
