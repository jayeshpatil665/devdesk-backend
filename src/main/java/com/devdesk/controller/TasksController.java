 package com.devdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devdesk.common.Constants;
import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.FilteredDataRequest;
import com.devdesk.request.NewTask;
import com.devdesk.request.SpecificTaskDetailsRequest;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.OverallTasksResponse;
import com.devdesk.service.TasksService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TasksController {
	
	@Autowired
	TasksService tasksService;
	
	@RequestMapping(value = "/addUpdateTask",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<CommonResponse> addNewTask(@RequestBody NewTask request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		System.out.println("request recieved : "+request.toString());
		CommonResponse response = tasksService.addNewTask(request);
		//CommonResponse response = new CommonResponse("success", "", "");
		return new ResponseEntity<CommonResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOverallTaskDetails",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<OverallTasksResponse> getOverallTaskDetails(@RequestBody AuthenticateUserRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		OverallTasksResponse response = tasksService.getOverallTaskDetails(request);
		return new ResponseEntity<OverallTasksResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSpecificTaskDetails",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<OverallTasksResponse> getSpecificTaskDetails(@RequestBody SpecificTaskDetailsRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		OverallTasksResponse response = tasksService.getSpecificTaskDetails(request);
		return new ResponseEntity<OverallTasksResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFilteredTaskDetails",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<OverallTasksResponse> getFilteredTaskDetails(@RequestBody FilteredDataRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		OverallTasksResponse response = tasksService.getFilteredTaskDetails(request);
		return new ResponseEntity<OverallTasksResponse>(response,HttpStatus.OK);
	}
	
}
