package com.roilka.main;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description="这里是service-a")
@RestController
public class DcController {

	@Autowired
	DiscoveryClient discoveryClient;
    
	@ApiOperation(value="我会延时5秒哦！",notes="你不服气？")
	@GetMapping("/dc")
	public String dc() throws InterruptedException {
		Thread.sleep(5000L);
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
	@ApiOperation(value="我才不会迟到呢！",notes="真不懂事！")
	@GetMapping("/dd")
	public String dd() throws InterruptedException {
		//Thread.sleep(5000L);
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
