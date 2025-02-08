package com.devdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devdesk.common.bean.User;
import com.devdesk.common.bean.UserPrincipal;
import com.devdesk.dao.AuthenticateUserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	AuthenticateUserDao authenticateUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String devTag = authenticateUserDao.isUserExist(username);
		if(devTag !=null){
			String encodedPwd = new BCryptPasswordEncoder(12).encode(devTag);
			User user = new User(username,encodedPwd);
			
			return new UserPrincipal(user);
		}else {
			throw new UsernameNotFoundException("User not found with username: "+ username);
		}
	}

}
