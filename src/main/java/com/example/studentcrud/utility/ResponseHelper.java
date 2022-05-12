package com.example.studentcrud.utility;

import com.example.studentcrud.Exception.ErrorCode;
import com.example.studentcrud.Exception.SOException;
import com.example.studentcrud.response.dto.GoodPlatformResponseVO;

public class ResponseHelper<T> {

	public static GoodPlatformResponseVO createResponse(GoodPlatformResponseVO response, Object data,
			String successMessage, String errorMessage) {
		if (data != null) {
			response.setSuccess(true);
			response.setData(data);
			response.setMessage(successMessage);
		} else {
			throw new SOException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
		}
		return response;
	}

}