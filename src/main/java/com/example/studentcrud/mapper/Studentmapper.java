package com.example.studentcrud.mapper;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.request.dto.StudentRequest;
import com.example.studentcrud.response.dto.StudentResponse;

public class Studentmapper {

	public  StudentResponse getStudentResponseFromStudentEntity(Student student) {

		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setSId(student.getSId());
		studentResponse.setSName(student.getSName());
		studentResponse.setSchoolName(student.getSchoolName());
		studentResponse.setAddress(student.getAddress());
		return studentResponse;
	}

	public Student getStudentFromStudentRequest(StudentRequest studentRequest) {

		Student student = new Student();
		student.setSId(studentRequest.getSId());
		student.setSName(studentRequest.getSName());
		student.setSchoolName(studentRequest.getSchoolName());
		student.setAddress(studentRequest.getAddress());
		return student;
	}
}
