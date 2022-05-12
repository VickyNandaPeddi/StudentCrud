package com.example.studentcrud.response.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentResponse {
	private Integer sId;
	private String sName;
	private String schoolName;
	private String address;

}
