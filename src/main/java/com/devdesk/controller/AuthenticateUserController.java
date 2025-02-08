package com.devdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devdesk.common.Constants;
import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.RegisterUserRequest;
import com.devdesk.response.AuthenticateUserBaseDetailResponse;
import com.devdesk.response.AuthenticateUserResponse;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.UsersNameDetail;
import com.devdesk.service.AuthenticateUserService;
import com.devdesk.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthenticateUserController {
	
	@Autowired
	AuthenticateUserService authenticateService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@RequestMapping(value = "/registerUser",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<CommonResponse> registerUser(@RequestBody RegisterUserRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		CommonResponse response = authenticateService.registerUser(request);
		return new ResponseEntity<CommonResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<AuthenticateUserResponse> authenticateUser(@RequestBody AuthenticateUserRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		AuthenticateUserResponse response = authenticateService.authenticateUser(request);
		
		if(response.getStatus().equalsIgnoreCase("SUCCESS")) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(""+request.getEmpId(), request.getDevTag()));
			
			if(authentication.isAuthenticated()) {
				String jwtToken = jwtService.generateToken(""+request.getEmpId());
				response.setToken(jwtToken);
			}
		}
		return new ResponseEntity<AuthenticateUserResponse>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserNameList",method = RequestMethod.POST,produces = Constants.PRODUCES)
	public ResponseEntity<UsersNameDetail> getUserNameList(@RequestBody AuthenticateUserRequest request,HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
		UsersNameDetail response = authenticateService.getUserNameList(request);
		return new ResponseEntity<UsersNameDetail>(response,HttpStatus.OK);
	}
	
	
	
}
