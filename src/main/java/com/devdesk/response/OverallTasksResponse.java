package com.devdesk.response;

import java.util.List;


public class OverallTasksResponse {

	private List<Task> taskList;

	public OverallTasksResponse() {
		super();
	}

	public OverallTasksResponse(List<Task> taskList) {
		super();
		this.taskList = taskList;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "OverallTasksResponse [taskList=" + taskList + "]";
	}
	
}
