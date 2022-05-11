package com.example.studentcrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcrud.Response.Response;
import com.example.studentcrud.entity.Student;
import com.example.studentcrud.service.Studentservice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class Studentcontroller {
	@Autowired
	private Studentservice studentservice;

	@PostMapping("/")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
		Student savedstudent = studentservice.addStudent(student);
		if (null != savedstudent) {
			return new ResponseEntity<>(new Response(true, "Product Details Saved", savedstudent), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Save Product Details", savedstudent),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/")
	public ResponseEntity<?> saveStudent() {
		List<Student> studentList = studentservice.findAllStudents();
		log.info("students list{} " + studentList);
		if (null != studentList && !studentList.isEmpty()) {
			return new ResponseEntity<>(new Response(true, "Students  List Fetched", studentList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Response(false, "Unable To Fetch Product List", studentList),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
