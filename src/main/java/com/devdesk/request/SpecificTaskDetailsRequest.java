package com.devdesk.request;

public class SpecificTaskDetailsRequest {

	private String empId;
	private String devTag;
	private int tId;
	
	public SpecificTaskDetailsRequest() {
		super();
	}

	public SpecificTaskDetailsRequest(String empId, String devTag, int tId) {
		super();
		this.empId = empId;
		this.devTag = devTag;
		this.tId = tId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDevTag() {
		return devTag;
	}

	public void setDevTag(String devTag) {
		this.devTag = devTag;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	@Override
	public String toString() {
		return "SpecificTaskDetailsRequest [empId=" + empId + ", devTag=" + devTag + ", tId=" + tId + "]";
	}
	
}