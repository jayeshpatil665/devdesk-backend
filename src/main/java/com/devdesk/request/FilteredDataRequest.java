package com.devdesk.request;

public class FilteredDataRequest {

	private int empId;
	private String devTag;
	
	private int taskStatus;
	private String taskType;
	private String clientName;
	
	public FilteredDataRequest() {
		super();
	}

	public FilteredDataRequest(int empId, String devTag, int taskStatus, String taskType, String clientName) {
		super();
		this.empId = empId;
		this.devTag = devTag;
		this.taskStatus = taskStatus;
		this.taskType = taskType;
		this.clientName = clientName;
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

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "FilteredDataRequest [empId=" + empId + ", devTag=" + devTag + ", taskStatus=" + taskStatus
				+ ", taskType=" + taskType + ", clientName=" + clientName + "]";
	}
	
}
