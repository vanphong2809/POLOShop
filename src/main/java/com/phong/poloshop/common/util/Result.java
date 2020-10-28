package com.phong.poloshop.common.util;


public enum Result {
	SUCCESS(1, "Success"),
	UNAUTHORIZED(401, "Unauthorized"),
	TOKEN_EXPIRE_TIME(401, "Token expire time"),
	BAD_REQUEST(400, "Bad request"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Api not found"),
	METHOD_NOT_ALLOW(405, "Method not allow"),
	SERVER_ERROR(500, "Server error");
	
	private int code;
	private String message;
	private int length;
	Result(int code, String message){
		this.code = code;
		this.message = message;
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
	
	public boolean isSuccess() {
		return (this.code==1);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
