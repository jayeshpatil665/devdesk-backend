package com.devdesk.request;

import org.springframework.stereotype.Component;

@Component
public class RegisterUserRequest {

	private int empId;
	private int devType;
	private String devTag;
	private String devPageAccess;
	private String devDesktaskId;
	
	private String devFirstname;
	private String devLastname;
	private String devBaselocation;
	private String devExperience;
	private String devTeam;
	
	public RegisterUserRequest() {
		super();
	}

	public RegisterUserRequest(int empId, int devType, String devTag, String devPageAccess, String devDesktaskId,
			String devFirstname, String devLastname) {
		super();
		this.empId = empId;
		this.devType = devType;
		this.devTag = devTag;
		this.devPageAccess = devPageAccess;
		this.devDesktaskId = devDesktaskId;
		this.devFirstname = devFirstname;
		this.devLastname = devLastname;
	}



	public RegisterUserRequest(int empId, int devType, String devTag, String devPageAccess, String devDesktaskId,
			String devFirstname, String devLastname, String devBaselocation, String devExperience, String devTeam) {
		super();
		this.empId = empId;
		this.devType = devType;
		this.devTag = devTag;
		this.devPageAccess = devPageAccess;
		this.devDesktaskId = devDesktaskId;
		this.devFirstname = devFirstname;
		this.devLastname = devLastname;
		this.devBaselocation = devBaselocation;
		this.devExperience = devExperience;
		this.devTeam = devTeam;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getDevType() {
		return devType;
	}

	public void setDevType(int devType) {
		this.devType = devType;
	}

	public String getDevTag() {
		return devTag;
	}

	public void setDevTag(String devTag) {
		this.devTag = devTag;
	}

	public String getDevPageAccess() {
		return devPageAccess;
	}

	public void setDevPageAccess(String devPageAccess) {
		this.devPageAccess = devPageAccess;
	}

	public String getDevDesktaskId() {
		return devDesktaskId;
	}

	public void setDevDesktaskId(String devDesktaskId) {
		this.devDesktaskId = devDesktaskId;
	}

	public String getDevFirstname() {
		return devFirstname;
	}

	public void setDevFirstname(String devFirstname) {
		this.devFirstname = devFirstname;
	}

	public String getDevLastname() {
		return devLastname;
	}

	public void setDevLastname(String devLastname) {
		this.devLastname = devLastname;
	}

	public String getDevBaselocation() {
		return devBaselocation;
	}

	public void setDevBaselocation(String devBaselocation) {
		this.devBaselocation = devBaselocation;
	}

	public String getDevExperience() {
		return devExperience;
	}

	public void setDevExperience(String devExperience) {
		this.devExperience = devExperience;
	}

	public String getDevTeam() {
		return devTeam;
	}

	public void setDevTeam(String devTeam) {
		this.devTeam = devTeam;
	}

	@Override
	public String toString() {
		return "RegisterUserRequest [empId=" + empId + ", devType=" + devType + ", devTag=" + devTag
				+ ", devPageAccess=" + devPageAccess + ", devDesktaskId=" + devDesktaskId + ", devFirstname="
				+ devFirstname + ", devLastname=" + devLastname + ", devBaselocation=" + devBaselocation
				+ ", devExperience=" + devExperience + ", devTeam=" + devTeam + "]";
	}
	
}
