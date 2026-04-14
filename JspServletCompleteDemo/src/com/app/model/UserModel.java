package com.app.model;

public class UserModel {

	private String userId;

	private String userName;

	private String city;

	private String state;

	private String pincode;

	public UserModel() {
		super();
	}

	public UserModel(String userId, String userName, String city, String state, String pincode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

}
