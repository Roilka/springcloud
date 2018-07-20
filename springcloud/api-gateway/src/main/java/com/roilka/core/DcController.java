package com.roilka.core;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description ="这是网关里的")
@RestController
public class DcController {

	@Autowired
	DiscoveryClient discoveryClient;

    @ApiOperation(value = "这是获取服务的",notes="详细注解")
	@GetMapping("/api-a/dc")
	public String dc() {
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
