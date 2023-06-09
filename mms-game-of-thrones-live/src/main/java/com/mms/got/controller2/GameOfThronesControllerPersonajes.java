package com.mms.got.controller2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/gameofthrones/personajes")
@Slf4j
public class GameOfThronesControllerPersonajes {

	private Faker faker = new Faker();

	private List<String> characters = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 20; i++) {
			characters.add(faker.gameOfThrones().character());
		}
	}

	@GetMapping
	@Operation(summary = "Get a list of characters from GoT")
	@ApiResponses(value = { 
			@ApiResponse(
					responseCode = "200", description = "Found the characters", 
					content = {
							@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class))) 
			}),
			@ApiResponse(
					responseCode = "404", description = "Characters not found", content = @Content
			) 
	})
	public ResponseEntity<List<String>> get() {
		log.info("Getting characters got");
		return ResponseEntity.ok(characters);
	}
}
