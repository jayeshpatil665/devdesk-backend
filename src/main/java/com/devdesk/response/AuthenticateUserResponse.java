package com.devdesk.response;

public class AuthenticateUserResponse {
	private String status;
	private int empId;
	private String devName;
	private String devTag;
	private String token;
	private String userIdleTimeOut;
	private String userIdleTimeOutPopup;
	
	public AuthenticateUserResponse() {
		super();
	}

	public AuthenticateUserResponse(String status, int empId, String devName, String devTag, String token,
			String userIdleTimeOut, String userIdleTimeOutPopup) {
		super();
		this.status = status;
		this.empId = empId;
		this.devName = devName;
		this.devTag = devTag;
		this.token = token;
		this.userIdleTimeOut = userIdleTimeOut;
		this.userIdleTimeOutPopup = userIdleTimeOutPopup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevTag() {
		return devTag;
	}

	public void setDevTag(String devTag) {
		this.devTag = devTag;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserIdleTimeOut() {
		return userIdleTimeOut;
	}

	public void setUserIdleTimeOut(String userIdleTimeOut) {
		this.userIdleTimeOut = userIdleTimeOut;
	}

	public String getUserIdleTimeOutPopup() {
		return userIdleTimeOutPopup;
	}

	public void setUserIdleTimeOutPopup(String userIdleTimeOutPopup) {
		this.userIdleTimeOutPopup = userIdleTimeOutPopup;
	}

	@Override
	public String toString() {
		return "AuthenticateUserResponse [status=" + status + ", empId=" + empId + ", devName=" + devName + ", devTag="
				+ devTag + ", token=" + token + ", userIdleTimeOut=" + userIdleTimeOut + ", userIdleTimeOutPopup="
				+ userIdleTimeOutPopup + "]";
	}
}
