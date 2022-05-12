package com.example.studentcrud.response;

import java.util.List;

import com.example.studentcrud.entity.Student;

public class Response {
	private boolean status;
	private String message;
	private Object datasource;
	private List<?> data;

	public Response(boolean b, String product_details_saved, List<Student> studentList) {
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Response(boolean b, String product_details_saved, Student savedstudent) {
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDatasource() {
		return datasource;
	}

	public void setDatasource(Object datasource) {
		this.datasource = datasource;
	}
}
