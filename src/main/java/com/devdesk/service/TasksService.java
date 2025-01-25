package com.devdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdesk.dao.TasksDaoImpl;
import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.FilteredDataRequest;
import com.devdesk.request.NewTask;
import com.devdesk.request.SpecificTaskDetailsRequest;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.OverallTasksResponse;

@Service
public class TasksService {

	@Autowired
	TasksDaoImpl tasksDao;
	
	public CommonResponse addNewTask(NewTask request) {
		
		return tasksDao.addNewTask(request);
	}

	public OverallTasksResponse getOverallTaskDetails(AuthenticateUserRequest request) {
		
		return tasksDao.getOverallTaskDetails(request);
	}

	public OverallTasksResponse getSpecificTaskDetails(SpecificTaskDetailsRequest request) {
		
		return tasksDao.getSpecificTaskDetails(request);
	}

	public OverallTasksResponse getFilteredTaskDetails(FilteredDataRequest request) {
		
		return tasksDao.getFilteredTaskDetails(request);
	}

}
