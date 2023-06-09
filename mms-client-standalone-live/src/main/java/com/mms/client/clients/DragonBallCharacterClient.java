package com.mms.client.clients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "devs4j-dragon-ball")
@LoadBalancerClient(name="devs4j-dragon-ball", configuration = MmsLoadBalancerConfiguration.class)
public interface DragonBallCharacterClient {
	
	@GetMapping(value = "/application-name")
	public ResponseEntity<String> getApplicationName();
}
