package com.soundify.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // to be used during ser.
@Setter // to be used during de-ser
public class ApiResponseWithBody {
	private String status;
	private String message;
	private LocalDateTime timeStamp;
	private Object responseObj;

	public ApiResponseWithBody(String status, String message, Object responseObj) {
		super();
		this.status = status;
		this.message = message;
		this.responseObj = responseObj;
		this.timeStamp = LocalDateTime.now();
	}

}
