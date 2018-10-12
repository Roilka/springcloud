package com.roilka.main.config;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.LeaseInfo;

/**
 * 
 * @author zhanghui1
 *
 */
@Component
public class EurekaStatusChangeListener {

	private Logger log = LoggerFactory.getLogger(EurekaStatusChangeListener.class);
	
	@Autowired
	private Environment env;
	/**
	 * 允许访问的ip白名单
	 */
	private String whiteIpList;
	
	@PostConstruct
	void initWhiteIpList(){
		whiteIpList = env.getProperty("enable.allowed.whiteIpList");
	}
	
	 @EventListener
	    public void listen(EurekaInstanceCanceledEvent event) {
	        log.info(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
	    }

	    @EventListener
	    public void listen(EurekaInstanceRegisteredEvent event) {
	        InstanceInfo instanceInfo = event.getInstanceInfo();
	        if (StringUtils.isBlank(whiteIpList)) {
	            log.info(instanceInfo.getAppName() + "进行注册");
	            return;
	        }

	        isAllowRegister(instanceInfo);
	    }

	    @EventListener
	    public void listen(EurekaInstanceRenewedEvent event) {
	        InstanceInfo instanceInfo = event.getInstanceInfo();
	        if (StringUtils.isBlank(whiteIpList)) {
	            log.info(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
	            return;
	        }

	        isAllowRegister(instanceInfo);
	    }

	    @EventListener
	    public void listen(EurekaRegistryAvailableEvent event) {
	        log.info("注册中心 启动");
	    }

	    @EventListener
	    public void listen(EurekaServerStartedEvent event) {
	        log.info("Eureka Server 启动");
	    }

	    /**
	     * 判断ip是否在白名单内
	     *
	     * @param instanceInfo 实例
	     */
	    private void isAllowRegister(InstanceInfo instanceInfo) {
	        String ipAddr = instanceInfo.getIPAddr();
	        if (StringUtils.isBlank(ipAddr) || !whiteIpList.contains(ipAddr)) {
	            //如果ip不在白名单，则不允许注册 马上踢下线
	            instanceInfo.setStatus(InstanceInfo.InstanceStatus.DOWN);
	            instanceInfo.setActionType(InstanceInfo.ActionType.DELETED);
	            LeaseInfo leaseInfo = LeaseInfo.Builder.newBuilder().setEvictionTimestamp(System.currentTimeMillis() - 1)
	                    .setDurationInSecs(1).setRenewalIntervalInSecs(1).build();
	            instanceInfo.setLeaseInfo(leaseInfo);
	        }
	    }
}
