package com.devdesk.response;

public class CommonResponse {
	private String status;
	private String message;
	private String error;
	
	public CommonResponse() {
		super();
	}

	public CommonResponse(String status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "CommonResponse [status=" + status + ", message=" + message + ", error=" + error + "]";
	}
	
}
