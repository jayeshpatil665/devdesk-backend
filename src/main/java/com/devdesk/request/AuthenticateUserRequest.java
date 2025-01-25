package com.devdesk.request;

import org.springframework.stereotype.Component;

@Component
public class AuthenticateUserRequest {
	private int empId;
	private String devTag;
	
	public AuthenticateUserRequest() {
		super();
	}

	public AuthenticateUserRequest(int empId, String devTag) {
		super();
		this.empId = empId;
		this.devTag = devTag;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDevTag() {
		return devTag;
	}

	public void setDevTag(String devTag) {
		this.devTag = devTag;
	}

	@Override
	public String toString() {
		return "AuthenticateUserRequest [empId=" + empId + ", devTag=" + devTag + "]";
	}
	
}
