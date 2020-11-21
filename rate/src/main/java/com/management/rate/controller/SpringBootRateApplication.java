package com.management.rate.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({ "com.management.rate" })
@EnableJpaRepositories("com.management.rate.dao")
@EntityScan(basePackages = { "com.management.rate.model" })
@RestController
//@EnableWebSecurity
public class SpringBootRateApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRateApplication.class, args);

	}

	/*@GetMapping("/")
	public String displayWelcome(Principal user) {
		return "Hello " + user.getName();

	}*/

	@Bean
	public RestTemplate getRestTemplate() {

		final RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

}
