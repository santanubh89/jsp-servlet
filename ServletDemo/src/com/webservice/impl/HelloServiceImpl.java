package com.webservice.impl;

import javax.jws.WebService;

import com.webservice.template.HelloServiceInterface;

@WebService(endpointInterface = "com.webservice.template.HelloServiceInterface")
public class HelloServiceImpl implements HelloServiceInterface{

	@Override
	public String printMessage() {
		return "Hello from Java Code Geeks Server";
	}

}