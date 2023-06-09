package com.mms.rest.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.mms.rest.exceptions.CharacterNotFound;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/characters")
public class CharacterController {
	
	private Faker faker = new Faker();
	private List<String> characters = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for (int i = 0; i < 10; i++) {
			characters.add(faker.dragonBall().character());
		}
	}
	
	@GetMapping(path = "/dragonBall")
	public ResponseEntity<Object> getCharacters() {
		return ResponseEntity.ok(characters);
	}
	
	@GetMapping(path = "/dragonBall/{name}")
	public ResponseEntity<Object> getCharacterByName(@PathVariable String name) {
		String character = characters.stream().filter(c -> c.equals(name)).findAny()
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND, String.format("%s don't found", name)));
		return ResponseEntity.ok(character);
	}
	
	@GetMapping(path = "/dragonBall/search")
	public ResponseEntity<Object> getCharactersByPrefix(@RequestParam(name = "prefix") String prefix) {
		List<String> result = characters.stream().filter(c -> c.startsWith(prefix)).toList();
		if(result.isEmpty()) throw new CharacterNotFound();
		return ResponseEntity.ok(result);
	}
}
