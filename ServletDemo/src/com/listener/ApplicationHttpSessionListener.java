package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ApplicationHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("A New Session is Created: "+se.getSource());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("A New Session is Created: "+se.getSource());

	}

}
