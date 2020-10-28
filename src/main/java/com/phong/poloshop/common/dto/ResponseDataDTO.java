package com.phong.poloshop.common.dto;

import com.phong.poloshop.common.util.Result;

public class ResponseDataDTO<T> {
	private int code;
	private String message; 
	private T Data;
	private int length;
	public ResponseDataDTO(Result result) {
		this.code = result.getCode();
		this.message = result.getMessage();
		this.length = result.getLength();
	}

	public ResponseDataDTO(int code, String message, T data, int length) {
		super();
		this.code = code;
		this.message = message;
		Data = data;
		this.length = length;
	}

	public ResponseDataDTO() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
