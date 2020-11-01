package com.ashish.mongo1.config;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;

@Component
public class ServiceDefnContxt {

	private final ConcurrentHashMap<String, String> swaggrResources;
	
	public ServiceDefnContxt() {
		this.swaggrResources = new ConcurrentHashMap<String,String>();
	}
	
	public void addServiceDefinition(String name, String content) {
		swaggrResources.put(name, content);
	}
	
	
	public List<SwaggerResource> getSwaggerDefinitions() {
		
		return swaggrResources.entrySet().stream().map(service -> {
			SwaggerResource resource = new SwaggerResource();
				resource.setName(service.getKey());
				resource.setUrl("/service/"+service.getKey());
				resource.setSwaggerVersion("2.0");
				return resource;
		}).collect(Collectors.toList());
	}

	public String getServiceDefinition(String serviceName) {
		return swaggrResources.get(serviceName);
	}

}
