package com.roilka.common.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.netflix.loadbalancer.ILoadBalancer;

import feign.Client;
import feign.Feign;


/**
 * 
* 类名: OkHttpClientConfig.java
* 包名 : com.roilka.common.config
* 详细描述: 这里需要个解释(用一句话描述该文件做什么)
* 开发人员： zhanghui1
* 开发日期：2018年10月11日 上午11:59:55
*
 */
@Configuration
@ConditionalOnClass({ OkHttpClient.class, Feign.class, ILoadBalancer.class })
@ConditionalOnProperty(value = "feign.okhttp.enabled", matchIfMissing = true)
@AutoConfigureBefore(FeignAutoConfiguration.class)
@EnableConfigurationProperties({OKHttpClientProperties.class })
public class OkHttpClientConfig {


	
	@Autowired
	private OKHttpClientProperties oKHttpClientProperties;
	
	@Bean
	@ConditionalOnMissingBean(Client.class)
	@Primary
	public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
			SpringClientFactory clientFactory) {

		OkHttpClient httpClient = null;
		ConnectionPool okHttpConnectionPool = null;

		// 没有自动注入则生成客户端接口实例
		if (httpClient == null) {
			// 连接池实例
			ConnectionPool connectionPool = okHttpConnectionPool;
			if (connectionPool == null) {
				connectionPool = new ConnectionPool();
			}

			// 返回缺省OkHttp客户端接口实例
			httpClient = new okhttp3.OkHttpClient.Builder()
					.readTimeout(oKHttpClientProperties.getReadTimeout(),
							oKHttpClientProperties.getClientTimeoutUnit())
					.connectTimeout(oKHttpClientProperties.getConnectTimeout(),
							oKHttpClientProperties.getClientTimeoutUnit())
					.writeTimeout(oKHttpClientProperties.getWriteTimeout(),
							oKHttpClientProperties.getClientTimeoutUnit())
					.connectionPool(connectionPool)
					.build();
		}
		// 使用Spring
		// cloud时Ribbon原有的LBClientFactory会被自动替换为CachingSpringLoadBalancerFactory
		// 使用Spring Coud
		return new LoadBalancerFeignClient(new feign.okhttp.OkHttpClient(
				httpClient), cachingFactory, clientFactory);

	}
}
