/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.roilka.common.config;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * 
* 类名: ExecutorConfig.java
* 包名 : com.roilka.common.config
* 详细描述: 配置线程池的相关参数
* 开发人员： zhanghui1
* 开发日期：2018年10月10日
*
 */
@Slf4j
@Configuration
@EnableAsync
@EnableConfigurationProperties({ ExecutorProperties.class })
public class ExecutorConfig {

    @Autowired
    private ExecutorProperties executorProperties;

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(executorProperties.getCorePoolSize());
        //设置最大线程数
        executor.setMaxPoolSize(executorProperties.getMaxPoolSize());
        //设置队列大小
        executor.setQueueCapacity(executorProperties.getQueueCapacity());
        //设置线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(executorProperties.getKeepAliveSeconds());
        //设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(executorProperties.isWaitForTasksToCompleteOnShutdown());
        //设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁
        executor.setAwaitTerminationSeconds(executorProperties.getAwaitTerminationSeconds());
        //设置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(executorProperties.getThreadNamePrefix());

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        RejectedExecutionHandler rejectedExecutionHandler = null;

        try {
            Class<?> clazz = Class
                    .forName("java.util.concurrent.ThreadPoolExecutor$" + executorProperties.getRejectionPolicyName());
            rejectedExecutionHandler = (RejectedExecutionHandler) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error("获取rejection-policy异常，请查看配置文件", e);
            return null;
        }
        executor.setRejectedExecutionHandler(rejectedExecutionHandler);
        //执行初始化
        executor.initialize();
        return executor;
    }
}
