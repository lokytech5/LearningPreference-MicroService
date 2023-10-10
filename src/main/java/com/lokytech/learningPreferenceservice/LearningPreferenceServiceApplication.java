package com.lokytech.learningPreferenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LearningPreferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPreferenceServiceApplication.class, args);
	}

}
