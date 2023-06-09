package com.mms.got.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TranslationService {

	public Map<String,String> words= new HashMap<>();
	
	@PostConstruct
	public void init() {
		words.put("Hello", "Hola");
		words.put("Bye", "Adios");
		words.put("Word", "Palabra");
	}
	
	@Cacheable("translations")
	public Optional<String> getTranslation(String message) {
		log.info("Doing translation for {}",message);
		for (String word : words.keySet()) {
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
			}
			if(word.equals(message)) {
				return Optional.of(words.get(message));
			}
		}
		return Optional.empty();
	}
	
	@CacheEvict("translations")
	public void clearCache(String message) {
	}
	}
