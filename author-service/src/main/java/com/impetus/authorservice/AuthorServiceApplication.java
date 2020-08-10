package com.impetus.authorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AuthorServiceApplication {

	@Bean
	public RestTemplate  getRestemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}

}
