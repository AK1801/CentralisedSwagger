package com.ashish.mongo1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(value = "http://localhost:8085")
@RequestMapping("/msfirst")
public class FirstMSResource {

	private WebClient wc = WebClient.create("http://localhost:8081/mssecond");

	@GetMapping("/ms1")
	public Mono<String> firstMS() {
		return wc.get()
				.uri("/ms2")
				.retrieve()
				.bodyToMono(String.class);
	}
	
}
