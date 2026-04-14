package com.app.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ApplicationServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// System.out.println("New request: " + sre.getServletRequest().getParameter("username"));

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// System.out.println("A New servlet request is Created: " + sre.getSource());
	}

}
