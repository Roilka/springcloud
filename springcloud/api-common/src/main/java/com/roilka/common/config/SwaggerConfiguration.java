package com.roilka.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
* 类名: SwaggerConfiguration.java
* 包名 : com.roilka.common.config
* 详细描述: swagger属性配置
* 开发人员： zhanghui1
* 开发日期：2018年10月11日 上午1:07:49
*
 */
@ConditionalOnClass(SwaggerConfiguration.class)
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Value("${common.enable-swagger}")
	private Boolean enabledSwagger;
    
    @Bean
    @ConditionalOnMissingBean(Docket.class)    
    public Docket buildDocket() {
		
    	if(enabledSwagger == null || !enabledSwagger) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select().paths(PathSelectors.none())
                    .build();
    	}
		
        ApiInfo apiInfo = new ApiInfoBuilder().title("百晓生API").contact("百晓生研发组").version("1.0.0")
                .build();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
                .apis(RequestHandlerSelectors.basePackage("com.tuhu")) // 要扫描的API(Controller)基础包
                .paths(PathSelectors.any()).build();
    }
}
