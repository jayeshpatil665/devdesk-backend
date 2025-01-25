package com.devdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdesk.dao.AuthenticateUserDao;
import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.RegisterUserRequest;
import com.devdesk.response.AuthenticateUserBaseDetailResponse;
import com.devdesk.response.AuthenticateUserResponse;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.UsersNameDetail;


@Service
public class AuthenticateUserService {
	
	@Autowired
	AuthenticateUserDao authenticateUserDao;
	
	public CommonResponse registerUser(RegisterUserRequest request) {
		
		return authenticateUserDao.registerUser(request);
	}

	public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest request) {
		
		return authenticateUserDao.authenticateUser(request);
	}

	public UsersNameDetail getUserNameList(AuthenticateUserRequest request) {
		
		return authenticateUserDao.getUserNameList(request);
	}
}
