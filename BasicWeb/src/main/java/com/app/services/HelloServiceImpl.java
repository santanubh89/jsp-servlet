package com.app.services;

import javax.jws.WebService;

import com.webservice.template.HelloServiceInterface;

@WebService(endpointInterface = "com.webservice.template.HelloServiceInterface")
public class HelloServiceImpl implements HelloServiceInterface{

	public String printMessage(String user) {
		return "Hello, "+user+"!";
	}


}