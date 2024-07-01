package com.example.demo.dto;

public class ApiResponse {

	private int status;

	private String message;


	public ApiResponse(ResponseStatus status, String message) {
		super();
		this.status = status.getStatus();
		this.message = message;
	}

	public ApiResponse() {
		super();
	}

	public static  ApiResponse success(String message) {
		return new ApiResponse(ResponseStatus.success, message);
	}

	public static  ApiResponse failed(String message) {
		return new ApiResponse(ResponseStatus.failed, message);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
