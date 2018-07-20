package com.roilka.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import com.roilka.core.filter.GlobalPreFilter;
import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApp {
	public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApp.class)
                    .web(true).run(args);
        
    }
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		@Override
		public List<SwaggerResource> get() {
			List resources = new ArrayList();
			resources.add(swaggerResource("service-a", "/eureka-client/v2/api-docs", "2.0"));
			resources.add(swaggerResource("service-b", "/eureka-client2/v2/api-docs", "2.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}
	}
}
