package com.example.studentcrud.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcrud.model.StudentModel;
import com.example.studentcrud.request.dto.StudentRequest;
import com.example.studentcrud.response.dto.GoodPlatformResponseVO;
import com.example.studentcrud.response.dto.StudentResponse;
import com.example.studentcrud.service.StudentService;
import com.example.studentcrud.utility.Constants;
import com.example.studentcrud.utility.ResponseHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class Studentcontroller {
	private final StudentService studentservice = null;

	@PostMapping("/")
	public GoodPlatformResponseVO<StudentResponse> saveStudent(@Valid @RequestBody StudentRequest studentRequest) {
		log.debug("Studnet Controller- save Student()");
		StudentResponse addStudent = studentservice.addStudent(studentRequest);
		log.debug("saved Student" + addStudent);

		return new ResponseHelper().createResponse(new GoodPlatformResponseVO<StudentResponse>(), addStudent,
				Constants.STUDENT_SAVED_SUCESSFULLY, Constants.STUDENT_NOT_SAVED_EXCEPTION);
	}

	@GetMapping("/")
	public GoodPlatformResponseVO<StudentResponse> findAllStudents() {
		log.debug("Student List- StudentController");
		StudentModel studentList = studentservice.findAllStudents();
		log.info("students list{} " + studentList);
		return ResponseHelper.createResponse(new GoodPlatformResponseVO<StudentResponse>(), studentList,
				Constants.STUDENT_FETCH_SUCESS, Constants.STUDENT_NOT_FOUND_EXCEPTION);
	}

}
