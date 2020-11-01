package com.ashish.mongo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.config.EnableWebFlux;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableWebFlux
@EnableEurekaClient
public class RMS2Application {
	
	RestTemplate rt;

	public static void main(String[] args) {
		SpringApplication.run(RMS2Application.class, args);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/mssecond/*"))
				.apis(RequestHandlerSelectors.basePackage("com.ashish.mongo1"))
				.build()
				.apiInfo( new ApiInfo(
						"Microservice API", 
						"Sample API for Swagger Use", 
						"1.0", 
						"Free to use", 
						"Ashish Kumar", 
						"API License", 
						"http://abc.com"));
	}

}
