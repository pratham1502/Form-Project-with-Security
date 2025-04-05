package com.example.FormProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FormProjectApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FormProjectApplication.class, args);
		System.out.print("Hello");
	}

}
