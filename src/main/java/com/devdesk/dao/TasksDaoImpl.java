package com.devdesk.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.devdesk.request.AuthenticateUserRequest;
import com.devdesk.request.FilteredDataRequest;
import com.devdesk.request.NewTask;
import com.devdesk.request.SpecificTaskDetailsRequest;
import com.devdesk.response.CommonResponse;
import com.devdesk.response.OverallTasksResponse;
import com.devdesk.response.Task;

@Repository
public class TasksDaoImpl {

	@Autowired
	JdbcTemplate jdbc;
	
	public CommonResponse addNewTask(NewTask request) {
		
		
		if(request.gettPickedBy().startsWith("undefined"))
			 request.settPickedBy(request.gettPickedBy().replace("undefined", ""));
		
		String sql;
		if(request.gettId()==0)
			sql = "INSERT INTO dev_tasks(task_id,task_pool,task_name,task_client_name,task_info,task_email,task_pickedby,task_reportdate,task_resolutiondate,task_tag,task_priority,task_status,task_solution) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		else
			sql = "UPDATE dev_tasks SET task_id = ?, task_pool = ?, task_name = ?, task_client_name = ?, task_info = ?, task_email = ?, task_pickedby = ?, task_reportdate = ?, task_resolutiondate = ?, task_tag = ?, task_priority = ?, task_status = ?, task_solution = ? "+
				  " WHERE task_id = "+request.gettId();
		
		int randomPrimaryKey = 0;
		if(request.gettId()==0) {
			randomPrimaryKey = generateUniqueTaskId(); //ThreadLocalRandom.current().nextInt(1, 1_000_000);
			request.settId(randomPrimaryKey);
		}
		
		CommonResponse response;
		try {
			int rowsAffected =  jdbc.update(sql,request.gettId(),request.gettPool(),request.gettName(),request.gettClient(),request.gettInfo(),request.gettEmail(),request.gettPickedBy(),
					getYMD(request.gettReportDate()),getYMD(request.gettResolutionDate()),request.gettTags(),request.gettPriority(),request.gettStatus(),request.gettSolution());
			System.out.println("Insert/Update status : "+rowsAffected);
			
			response = new CommonResponse("SUCCESS", (rowsAffected>=1)?"New task added/upadted succcesfully":"Unable to Add/update Task", "");
			
		}catch (Exception e) {
			System.out.println("Exception occured while add/update task : "+e.getMessage());
			e.printStackTrace();
			response = new CommonResponse("FAILURE", "Unable to add/update task", "Unable to add/update task");
		}
		
		return response;
	}
	
	public Date getYMD(String req) {
		LocalDate localDate = LocalDate.parse(req);
	    return Date.valueOf(localDate);
	}
	
	private int generateUniqueTaskId() {
	    int randomId;
	    do {
	        randomId = ThreadLocalRandom.current().nextInt(1, 1_000_000);
	    } while (isTaskIdExists(randomId));
	    return randomId;
	}
	
	private boolean isTaskIdExists(int taskId) {
	    String checkQuery = "SELECT COUNT(*) FROM dev_tasks WHERE task_id = ?";
	    Integer count = jdbc.queryForObject(checkQuery, new Object[]{taskId}, Integer.class);
	    return count != null && count > 0;
	}

	public OverallTasksResponse getOverallTaskDetails(AuthenticateUserRequest request) {
		String sql = "SELECT * FROM dev_tasks";
		return getCommonTask(sql);
	}

	public OverallTasksResponse getSpecificTaskDetails(SpecificTaskDetailsRequest request) {
		String sql = "SELECT * FROM dev_tasks WHERE task_id = "+request.gettId();
		return getCommonTask(sql);
	}

	public OverallTasksResponse getFilteredTaskDetails(FilteredDataRequest request) {
		String sql = "SELECT * FROM dev_tasks WHERE task_pickedby like '%"+request.getEmpId()+"%' "
										  + " AND task_status = "+request.getTaskStatus();
										 // +" "+ " AND task_client_name = "+request.getClientName();
		return getCommonTask(sql);
	}

	
	private OverallTasksResponse getCommonTask(String sql) {
		//functional interface -- can be reduced to lambda expression
		RowMapper<Task> mapper = new RowMapper<Task>() {
			
			@Override
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				//task picked by
				String taskPickIdName[] = rs.getString("task_pickedby").toString().split("~");
				
				if(taskPickIdName[0].startsWith("undefined"))
					taskPickIdName[0].replace("undefined", "");
				
				Map<String, Integer> pickedBy = new HashMap<>();
				for(String idName : taskPickIdName) {
					String[] keyVal = idName.split(":");
					if(keyVal.length==2) {
						pickedBy.put(keyVal[1],Integer.parseInt(keyVal[0]));
					}
					else if(keyVal.length==3) {
						pickedBy.put(keyVal[1]+
							     keyVal[2].substring(0,1).toUpperCase()+keyVal[2].substring(1), 
							     Integer.parseInt(keyVal[0]));
					}
					
				}
				
				//task tag
				String taskTags[] = rs.getString("task_tag").toString().split("~");
				
				if(taskTags[0].startsWith("undefined"))
					taskTags[0] = taskTags[0].replace("undefined", "");
				
				return new Task(rs.getInt("task_id"),
						rs.getInt("task_pool"),
						rs.getString("task_name"),
						rs.getString("task_client_name"),
						rs.getString("task_info"),
						rs.getString("task_email"),
						pickedBy,//"task_pickedby"
						rs.getDate("task_reportdate"),
						rs.getDate("task_resolutiondate"),
						taskTags, //"task_tag"
						rs.getInt("task_priority"),
						rs.getInt("task_status"),
						rs.getString("task_solution"));
			}
		};
		
		List<Task> taskList = jdbc.query(sql, mapper);
		
		return new OverallTasksResponse(taskList);
	}
	
	
}
