package com.mms.dragonball.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.mms.dragonball.service.FooService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/dragonball/characters")
@Slf4j
public class DragonBallController {
	
	@Autowired
	private FooService fooService;

	private Faker faker = new Faker();

	private List<String> characters = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 20; i++) {
			characters.add(faker.dragonBall().character());
		}
	}

	@GetMapping
	public ResponseEntity<List<String>> get() {
		log.info("Getting characters db");
		fooService.printLog();
		return ResponseEntity.ok(characters);
	}
}
