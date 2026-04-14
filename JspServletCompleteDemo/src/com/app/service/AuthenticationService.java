package com.app.service;

import java.util.HashMap;
import java.util.Map;

import com.app.model.UserModel;

public class AuthenticationService {

	private Map<String, String> allowedUsers;
	
	private Map<String, UserModel> userInformation;

	public AuthenticationService() {
		allowedUsers = new HashMap<String, String>();
		allowedUsers.put("username1", "password1");
		allowedUsers.put("username2", "password2");
		
		userInformation = new HashMap<String, UserModel>();
		userInformation.put("username1", new UserModel("username1", "User1Name", "User1City", "User1State", "User1Pin"));
		userInformation.put("username3", new UserModel("username3", "User3Name", "User3City", "User3State", "User2Pin"));
	}
	
	public boolean authenticate(String username, String password) {
		if (isEmpty(username) || isEmpty(password))
			return false;
		if (password.equals(allowedUsers.get(username)))
			return true;
		return false;
	}

	public UserModel getUser(String username, String password) {
		return userInformation.get(username);
	}

	private boolean isEmpty(String string) {
		return (string == null || string.trim().length() == 0);
	}

}
