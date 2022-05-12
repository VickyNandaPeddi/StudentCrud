package com.example.studentcrud.Exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class ErrorResponse {

	
	private int errorcode;
	private String message;
	private Boolean sucess;
	private Object errordata;
}
