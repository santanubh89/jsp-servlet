package com.app.model;

public class User {

	private String username;
	private String userFullName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", UserFullName=" + userFullName + "]";
	}

	public User(String username, String userFullName) {
		super();
		this.username = username;
		this.userFullName = userFullName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
