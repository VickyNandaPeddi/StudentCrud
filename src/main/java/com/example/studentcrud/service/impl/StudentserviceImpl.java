package com.example.studentcrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentcrud.Exception.ErrorCode;
import com.example.studentcrud.Exception.SOException;
import com.example.studentcrud.entity.Student;
import com.example.studentcrud.mapper.Studentmapper;
import com.example.studentcrud.model.StudentModel;
import com.example.studentcrud.repository.StudentDao;
import com.example.studentcrud.request.dto.StudentRequest;
import com.example.studentcrud.response.dto.StudentResponse;
import com.example.studentcrud.service.StudentService;
import com.example.studentcrud.utility.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentserviceImpl implements StudentService {

	private Studentmapper studentmapper;
	@Autowired
	private StudentDao studentrepos;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentResponse addStudent(StudentRequest studentRequest) {
		log.debug("Adding Student Data Save Starts");
		if (studentrepos.existsById(studentRequest.getSId())) {
			throw new SOException(ErrorCode.CONFLICT, Constants.STUDENT_ALREADY_EXISTS_EXCEPTION);
		}
		StudentResponse studentResponse = null;
		try {
			Student studentFromStudentRequest = studentmapper.getStudentFromStudentRequest(studentRequest);
			Student savedStudent = studentrepos.save(studentFromStudentRequest);
			StudentResponse studentResponseFromStudentEntity = studentmapper
					.getStudentResponseFromStudentEntity(savedStudent);
			return studentResponseFromStudentEntity;
		} catch (Exception exception) {
			log.error(exception.getMessage());
			if (Constants.STUDENT_ALREADY_EXISTS_EXCEPTION.equals(exception.getMessage())) {
				throw new SOException(ErrorCode.CONFLICT, Constants.STUDENT_ALREADY_EXISTS_EXCEPTION);
			} else {
				throw new SOException(ErrorCode.INTERNAL_SERVER_ERROR, Constants.STUDENT_NOT_SAVED_EXCEPTION);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StudentResponse updateStudent(int sid, StudentRequest studentRequest) {
		log.debug("Update Student Data Save Starts");
		if (!studentrepos.existsById(sid)) {
			throw new SOException(ErrorCode.NOT_FOUND, Constants.STUDENT_NOT_FOUND_EXCEPTION);
		}
		try {
			StudentResponse studentResponse = null;
			Student studentFromStudentRequest = studentmapper.getStudentFromStudentRequest(studentRequest);
			Student updatablestudent = studentrepos.findById(sid).get();
			updatablestudent.setSName(studentFromStudentRequest.getSName());
			updatablestudent.setAddress(studentFromStudentRequest.getAddress());
			updatablestudent.setSchoolName(studentFromStudentRequest.getSchoolName());
			log.info("Student  Detail {}" + updatablestudent);
			Student updatedStudent = studentrepos.save(updatablestudent);
			studentResponse = studentmapper.getStudentResponseFromStudentEntity(updatedStudent);
			return studentResponse;
		} catch (Exception exception) {
			log.error(exception.getMessage());
			if (Constants.STUDENT_NOT_FOUND_EXCEPTION.equals(exception.getMessage())) {
				throw new SOException(ErrorCode.CONFLICT, Constants.STUDENT_NOT_FOUND_EXCEPTION);
			} else {
				throw new SOException(ErrorCode.INTERNAL_SERVER_ERROR, Constants.STUDENT_NOT_SAVED_EXCEPTION);
			}
		}

	}

	@Override
	public Boolean deleteStudent(int sid) {
		log.debug("Delete Student Data  Starts");
		if (!studentrepos.existsById(sid)) {
			throw new SOException(ErrorCode.NOT_FOUND, Constants.STUDENT_NOT_FOUND_EXCEPTION);
		}
		try {
			Boolean status = false;
			Student student = studentrepos.findById(sid).get();

			log.info("Product Details {}" + student);
			studentrepos.deleteById(sid);
			status = true;
			return status;
		} catch (Exception exception) {
			log.error(exception.getMessage());
			if (Constants.STUDENT_NOT_FOUND_EXCEPTION.equals(exception.getMessage())) {
				throw new SOException(ErrorCode.CONFLICT, Constants.STUDENT_NOT_FOUND_EXCEPTION);
			} else {
				throw new SOException(ErrorCode.INTERNAL_SERVER_ERROR, Constants.STUDENT_DELETE_EXCEPTION);
			}
		}

	}

	@Override
	public StudentModel findAllStudents() {
		log.debug("Fetch Student list Starts");
		try {
			StudentModel studentModel = new StudentModel();
			List<Student> findAll = studentrepos.findAll();
			studentModel.setStudents(findAll);
			return studentModel;
		} catch (Exception exception) {
			log.error(exception.getMessage());
			throw new SOException(ErrorCode.INTERNAL_SERVER_ERROR, Constants.STUDENT_DELETE_EXCEPTION);

		}

	}

}
