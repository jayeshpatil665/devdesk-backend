package com.devdesk.response;

import java.util.Arrays;

public class UsersNameDetail {
	
	private TaskPickedBy usersList[];

	public UsersNameDetail() {
		super();
	}

	public UsersNameDetail(TaskPickedBy[] usersList) {
		super();
		this.usersList = usersList;
	}

	public TaskPickedBy[] getUsersList() {
		return usersList;
	}

	public void setUsersList(TaskPickedBy[] usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "UsersNameDetail [usersList=" + Arrays.toString(usersList) + "]";
	}

}
