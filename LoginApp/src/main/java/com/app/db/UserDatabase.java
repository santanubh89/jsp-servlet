package com.app.db;

import java.util.HashMap;

import com.app.model.User;

public class UserDatabase {
	
	public HashMap<String, User> userData = new HashMap<String, User>();

	public UserDatabase(){
		userData.put("username1", new User("username1", "User Name 1"));
		userData.put("username2", new User("username2", "User Name 2"));
		userData.put("username3", new User("username3", "User Name 3"));
		userData.put("username4", new User("username4", "User Name 4"));
	}
}
