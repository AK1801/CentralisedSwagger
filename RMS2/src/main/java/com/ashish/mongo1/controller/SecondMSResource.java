package com.ashish.mongo1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "http://localhost:8085")
@RequestMapping("/mssecond")
public class SecondMSResource {

	
	@GetMapping("/ms2")
	public Mono<String> SecondMS() {
		return Mono.just("Hello World");
		}
	
}
