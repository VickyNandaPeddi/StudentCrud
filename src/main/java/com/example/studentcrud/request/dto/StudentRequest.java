package com.example.studentcrud.request.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentRequest {
	private Integer sId;
	private String sName;
	private String schoolName;
	private String address;

}
