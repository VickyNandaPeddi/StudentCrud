package com.example.studentcrud.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SOException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String message;

	public SOException(String message) {
		super(message);
		this.message = message;
	}

	public SOException(ErrorCode error, Exception ex) {
		super(ex);
		this.errorCode = error;
		this.message = ex.getMessage();
	}

	public SOException(Exception ex) {
		super(ex);
		this.message = ex.getMessage();
	}

	public SOException(ErrorCode errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

}
