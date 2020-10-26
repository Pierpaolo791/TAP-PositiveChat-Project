package com.tap.positiveingestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tap.positiveingestor.service.ActionsList;

@SpringBootApplication
public class PositiveIngestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositiveIngestorApplication.class, args);
	}
	
	@Bean
	public ActionsList beanActionList() {
		return new ActionsList(); 
	}

}
