package com.mms.cloudstream;

//import java.time.Duration;
//import java.util.function.Consumer;
import java.util.function.Function;
//import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Flux;

@SpringBootApplication
@Slf4j
public class MmsCloudstreamExampleApplication {
	
	@Bean
	public Function<String, String> toUpperCase() {
		return data -> {
			log.info("Data {}", data);
			return data.toUpperCase();
		};
	}
	
	/**
	 *  producer-out-0
	 */
//	@Bean
//	public Supplier<Flux<Long>> producer() {
//		return () -> Flux.interval(Duration.ofSeconds(1)).log();
//	}
	
	/**
	 * processor-in-0
	 * processor-out-0
	 */
//	@Bean
//	public Function<Flux<Long>, Flux<Long>> processor() {
//		return flx -> flx.map(nmbr -> nmbr * nmbr);
//	}
	
	/** 
	 * consumer-in-0
	 */
//	@Bean
//	public Consumer<Long> consumer() {
//		return (number) -> {
//			log.info("Message received {}", number);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(MmsCloudstreamExampleApplication.class, args);
	}

}
