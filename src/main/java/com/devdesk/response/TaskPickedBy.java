package com.devdesk.response;

public class TaskPickedBy {

	private int empId;
	private String name;
	
	public TaskPickedBy() {
		super();
	}

	public TaskPickedBy(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TaskPickedBy [empId=" + empId + ", name=" + name + "]";
	}
	
}
