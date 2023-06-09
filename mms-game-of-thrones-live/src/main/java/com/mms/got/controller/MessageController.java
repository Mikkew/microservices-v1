package com.mms.got.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mms.got.services.TranslationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/translations")
@Slf4j
public class MessageController {
	
	@Autowired
	private TranslationService service;

	@GetMapping
	public ResponseEntity<String> getTranslation(@RequestParam("message") String message) {
		log.info("Message received {} ", message);
		Optional<String> translation = service.getTranslation(message);
		if(translation.isPresent()) {
			return ResponseEntity.ok(translation.get());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public void clearCache(@RequestParam("message") String message) {
		log.info("Cleaning cache for {}",message);
		service.clearCache(message);
	}
}
