package com.example.studentcrud.model;

import lombok.Setter;

import lombok.Getter;

import java.util.List;

import com.example.studentcrud.entity.Student;

import lombok.Data;

@Data
@Getter
@Setter
public class StudentModel {
	private List<Student> students;
}
