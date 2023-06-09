package com.mms.dragonball.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mms.dragonball.config.DragonBallConfig;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(path = "/application-name")
@Slf4j
public class ApplicationNameController {
	
	@Autowired
	private DragonBallConfig configuration;
	
	@Autowired
	private MeterRegistry registry;
	
	@GetMapping
	@Timed("mms.dragonball.name.get")
	public ResponseEntity<String> getAppName() {
		log.info("Getting application name");
		int value = new Random().nextInt(5);
		registry.counter("mms.dragonball.name", "level", (value < 3) ? "jr" : "sr").increment(value);
		if (value < 3) throw new ResponseStatusException(BAD_REQUEST);
		return ResponseEntity.ok(configuration.getApplicationName());
	}
}
