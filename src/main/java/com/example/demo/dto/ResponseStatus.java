package com.example.demo.dto;

public enum ResponseStatus {

	success(1), failed(0);

	private int status;

	ResponseStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
