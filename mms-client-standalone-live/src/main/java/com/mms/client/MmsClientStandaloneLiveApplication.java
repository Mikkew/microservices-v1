package com.mms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.mms.client.clients.DragonBallCharacterClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class MmsClientStandaloneLiveApplication implements ApplicationRunner {

//	@Autowired
//	private EurekaClient eurekaClient;
	
	@Autowired
	private DragonBallCharacterClient dragonBallClient;

	public static void main(String[] args) {
		SpringApplication.run(MmsClientStandaloneLiveApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 10; i++) {
			ResponseEntity<String> responseEntity = dragonBallClient.getApplicationName();
			log.info("Status {}", responseEntity.getStatusCode());
			String body = responseEntity.getBody();
			log.info("Body {}", body);			
		}
	}

	/**
	 * Implementacion de cliente de Eureka
	 */

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		Application application = eurekaClient.getApplication("devs4j-dragon-ball");	
//		log.info("Application name {}", application.getName());
//		
//		List<InstanceInfo> instances = application.getInstances();
//		for (InstanceInfo instanceInfo : instances) {
//			log.info("IP Address {}:{}", instanceInfo.getIPAddr(), instanceInfo.getPort());
//		}
//	}

}
