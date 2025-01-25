package com.devdesk.response;

public class AuthenticateUserBaseDetailResponse {
	private String empId;
	private String devType;
	private String devTag;
	private String devFName;
	private String devLName;
	private String devPageAccess;
	
	public AuthenticateUserBaseDetailResponse() {
		super();
	}

	public AuthenticateUserBaseDetailResponse(String empId, String devType, String devTag, String devFName,
			String devLName, String devPageAccess) {
		super();
		this.empId = empId;
		this.devType = devType;
		this.devTag = devTag;
		this.devFName = devFName;
		this.devLName = devLName;
		this.devPageAccess = devPageAccess;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDevType() {
		return devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
	}

	public String getDevTag() {
		return devTag;
	}

	public void setDevTag(String devTag) {
		this.devTag = devTag;
	}

	public String getDevFName() {
		return devFName;
	}

	public void setDevFName(String devFName) {
		this.devFName = devFName;
	}

	public String getDevLName() {
		return devLName;
	}

	public void setDevLName(String devLName) {
		this.devLName = devLName;
	}

	public String getDevPageAccess() {
		return devPageAccess;
	}

	public void setDevPageAccess(String devPageAccess) {
		this.devPageAccess = devPageAccess;
	}

	@Override
	public String toString() {
		return "AuthenticateUserBaseDetailResponse [empId=" + empId + ", devType=" + devType + ", devTag=" + devTag
				+ ", devFName=" + devFName + ", devLName=" + devLName + ", devPageAccess=" + devPageAccess + "]";
	}
	
}
