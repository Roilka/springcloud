package com.roilka.common.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 
* 类名: ExecutorProperties.java
* 包名 : com.roilka.common.config
* 详细描述: 线程池参数属性配置
* 开发人员： zhanghui1
* 开发日期：2018年10月10日
*
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "executor.conf")
public class ExecutorProperties {

    /**
     * 核心线程数
     */
    private int     corePoolSize                     = 10;
    /**
     * 最大线程数
     */
    private int     maxPoolSize                      = 20;
    /**
     * 队列大小
     */
    private int     queueCapacity                    = 200;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private int     keepAliveSeconds                 = 60;

    /**
     * 线程池关闭的时候是否等待所有任务都完成再继续销毁其他的Bean
     */
    private boolean waitForTasksToCompleteOnShutdown = true;
    /**
     * 线程池中任务的等待时间
     */
    private int     awaitTerminationSeconds          = 60;
    /**
     * 线程的名称前缀
     */
    private String  threadNamePrefix                 = "taskExecutor-";
    /**
     * 拒绝策略{@link ThreadPoolExecutor.CallerRunsPolicy}
     */
    private String  rejectionPolicyName              = "CallerRunsPolicy";
    
}
