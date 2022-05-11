package com.example.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentcrud.Exception.RresourcenotfoundExcception;
import com.example.studentcrud.dao.StudentDao;
import com.example.studentcrud.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j
public class Studentservice {
	@Autowired
	private StudentDao studentDao;

	@Transactional(rollbackFor = Exception.class)
	public Student addStudent(Student student) {
		Student savedStudent = studentDao.save(student);
		return savedStudent;
	}

	@Transactional(rollbackFor = Exception.class)
	public Student updateStudent(int sid, Student student) {
		Student updatablestudent = studentDao.findById(sid).get();
		if (null == updatablestudent) {
			throw new RresourcenotfoundExcception("Student  Details Not Found");
		} else {
			updatablestudent.setSname(student.getSname());
			updatablestudent.setAddress(student.getAddress());
//            logger.info("Student  Detail {}" + updatablestudent);
			return studentDao.save(updatablestudent);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean deleteStudent(int sid) {
		boolean status = false;
		Student student = studentDao.findById(sid).get();
		if (null == student) {
			throw new RresourcenotfoundExcception("Student Details Not Found");
		} else {
//            logger.info("Product Details {}" + student);
			studentDao.deleteById(sid);
			status = true;
		}
		return status;
	}

	public List<Student> findAllStudents() {
		List<Student> studentList = studentDao.findAll();
		if (null == studentList || studentList.isEmpty()) {
			throw new RresourcenotfoundExcception("Student List Not Found");
		} else {
			return studentList;
		}
	}

}
