package com.devdesk.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.RegisterUserRequest;
import com.devdesk.response.AuthenticateUserResponse;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.TaskPickedBy;
import com.devdesk.response.UsersNameDetail;

@Repository
public class AuthenticateUserDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	public AuthenticateUserResponse authenticateUser(AuthenticateUserRequest request) {
		
		String sql = "SELECT * FROM dev_user WHERE dev_empid = "+request.getEmpId()+" AND dev_tag =  '"+request.getDevTag()+"'";

		RowMapper<RegisterUserRequest> rowMapper = new RowMapper<RegisterUserRequest>() {
			
			@Override
			public RegisterUserRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new RegisterUserRequest(rs.getInt("dev_empid"), 
											   rs.getInt("dev_type"), 
											   rs.getString("dev_tag"), 
											   rs.getString("dev_page_access"), 
											   rs.getString("dev_desktask_id"),
											   rs.getString("dev_firstname").toString(),
											   rs.getString("dev_lastname").toString());
			}
		};
		
		List<RegisterUserRequest> userDetailList = jdbc.query (sql,rowMapper);
		
		System.out.println(userDetailList);
		
		if(userDetailList.isEmpty())
			return new AuthenticateUserResponse("FAILURE", 0, "", "",  "token", "userIdleTimeOut", "userIdleTimeOutPopup");
		
		return new AuthenticateUserResponse("SUCCESS", userDetailList.get(0).getEmpId(), userDetailList.get(0).getDevFirstname()+userDetailList.get(0).getDevLastname(), userDetailList.get(0).getDevTag(),  "Give-Respect_Take-respect", "60", "15");
	}

	public CommonResponse registerUser(RegisterUserRequest request) {
		
		String sql = "INSERT INTO dev_user(dev_empid,dev_type,dev_tag,dev_page_access,dev_desktask_id,dev_firstname,dev_lastname,dev_baselocation,dev_experience,dev_dev_team) values(?,?,?,?,?,?,?,?,?,?)";
		
		CommonResponse response;
		try {
			int rowsAffected =  jdbc.update(sql,request.getEmpId(),request.getDevType(),request.getDevTag(),request.getDevPageAccess(),request.getDevDesktaskId(),request.getDevFirstname(),request.getDevLastname(),request.getDevBaselocation(),request.getDevExperience(),request.getDevTeam());
			System.out.println("Insert status : "+rowsAffected);
			
			response = new CommonResponse("SUCCESS", (rowsAffected>=1)?"User register success":"Unable to register user", "");
			
		}catch (Exception e) {
			response = new CommonResponse("FAILURE", "Unable to register user", "user with same empId might exist already");
		}
		
		return response;
	}

	public UsersNameDetail getUserNameList(AuthenticateUserRequest request) {
		
		String sql = "SELECT dev_empid,dev_firstname,dev_lastname FROM dev_user";
		
		RowMapper<TaskPickedBy> rowMapper = new RowMapper<TaskPickedBy>() {
			
			@Override
			public TaskPickedBy mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new TaskPickedBy(rs.getInt("dev_empid"), rs.getString("dev_firstname")+rs.getString("dev_lastname"));
						//rs.getString("dev_firstname").substring(0,1).toUpperCase()+rs.getString("dev_firstname").substring(1)+
						//rs.getString("dev_lastname").substring(0,1).toUpperCase()+rs.getString("dev_lastname").substring(1));
			}
		};
		
		List<TaskPickedBy> usersList = jdbc.query(sql, rowMapper);
		
		TaskPickedBy userNames[] = new TaskPickedBy[usersList.size()];
		
		for(int i=0;i<usersList.size();i++)
			userNames[i] = usersList.get(i);
		
		
		return new UsersNameDetail(userNames);
	}

}
