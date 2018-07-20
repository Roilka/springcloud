package com.roilka.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient2App {
	public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClient2App.class)
                    .web(true).run(args);
    }
}
