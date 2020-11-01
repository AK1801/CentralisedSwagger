package com.ashish.mongo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.mongo1.config.ServiceDefnContxt;

@RestController
public class ServiceDefinitionController {
	
	@Autowired
	ServiceDefnContxt context;
	
	@GetMapping("/service/{serviceName}")
	public String getServiceDefinition(@PathVariable("serviceName") String serviceName) {
		return context.getServiceDefinition(serviceName);
	}
}
