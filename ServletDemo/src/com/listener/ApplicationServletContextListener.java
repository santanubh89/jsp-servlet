package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Context Destroyed...");

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Context Initialized...");
		System.out.println("Event Desc: " + event.getServletContext().getInitParameterNames().nextElement());

	}
}
