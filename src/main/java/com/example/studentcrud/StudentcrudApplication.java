package com.example.studentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studentcrud.mapper.Studentmapper;

@SpringBootApplication
public class StudentcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentcrudApplication.class, args);
	}

	@Bean
	public Studentmapper studentmapper() {
		return new Studentmapper();
	}
}
