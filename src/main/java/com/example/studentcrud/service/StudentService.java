package com.example.studentcrud.service;

import java.util.List;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.model.StudentModel;
import com.example.studentcrud.request.dto.StudentRequest;
import com.example.studentcrud.response.dto.StudentResponse;

public interface StudentService {
	public StudentResponse addStudent(StudentRequest studentRequest);

	public StudentResponse updateStudent(int sid, StudentRequest studentRequest);

	public Boolean deleteStudent(int id);

	public StudentModel findAllStudents();
}
