package com.ashish.mongo1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceDescriptionUpdater {

	@Autowired
	private DiscoveryClient discoveryClient;

	private final RestTemplate template;

	public ServiceDescriptionUpdater() {
		this.template = new RestTemplate();
	}

	@Autowired
	private ServiceDefnContxt definitionContext;

	@Scheduled(fixedDelayString = "${swagger.config.refreshrate}")
	public void refreshSwaggerConfigurations() {
		discoveryClient.getServices().stream().forEach(serviceId -> {
			List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
			if (serviceInstances == null || serviceInstances.isEmpty()) { 
				System.out.println("No instances available for service : {} "+ serviceId);
			}else {
				ServiceInstance instance = serviceInstances.get(0);
				String swaggerURL = instance.getUri()+"/v2/api-docs/";
				Object jsonData = template.getForObject(swaggerURL, Object.class);
				String content = getJSON(serviceId, jsonData);
				definitionContext.addServiceDefinition(serviceId, content);
				}});
	}

	public String getJSON(String serviceId, Object jsonData) {
		try {
			return new ObjectMapper().writeValueAsString(jsonData);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}