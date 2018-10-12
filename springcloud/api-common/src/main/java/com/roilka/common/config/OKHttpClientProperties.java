package com.roilka.common.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "common.okhttp.client")
public class OKHttpClientProperties {

	/**
	 * 默认读超时值
	 */
	private long readTimeout = 60 * 1000;
	/**
	 * 默认单位
	 */
	private TimeUnit clientTimeoutUnit = TimeUnit.MILLISECONDS;
	/**
	 * 默认连接超时值
	 */
	private long connectTimeout = 10 * 1000;

	/**
	 * 默认写超时
	 */
	private long writeTimeout = 60 * 1000;
	

	public long getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(long readTimeout) {
		this.readTimeout = readTimeout;
	}

	public TimeUnit getClientTimeoutUnit() {
		return clientTimeoutUnit;
	}

	public void setClientTimeoutUnit(TimeUnit clientTimeoutUnit) {
		this.clientTimeoutUnit = clientTimeoutUnit;
	}

	public long getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public long getWriteTimeout() {
		return writeTimeout;
	}

	public void setWriteTimeout(long writeTimeout) {
		this.writeTimeout = writeTimeout;
	}

}
