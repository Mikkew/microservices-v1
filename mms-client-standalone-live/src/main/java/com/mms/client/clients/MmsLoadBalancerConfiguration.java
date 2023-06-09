package com.mms.client.clients;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MmsLoadBalancerConfiguration {

	@Bean
	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ConfigurableApplicationContext context) {
		log.info("Configuring Load balancer to prefer same instance");
		return ServiceInstanceListSupplier.builder()
				//.withSameInstancePreference()
				.withBlockingDiscoveryClient()
				.build(context);
	}
}
