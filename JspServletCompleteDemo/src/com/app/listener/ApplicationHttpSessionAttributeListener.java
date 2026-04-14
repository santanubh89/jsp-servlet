package com.app.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ApplicationHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// System.out.println("A new session attribute added: " + se.getName() + " " + se.getSource() + " " + se.getValue());

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// System.out.println("A new session attribute removed: " + se.getName() + " " + se.getSource() + " " + se.getValue());

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// System.out.println("A new session attribute replaced: " + se.getName() + " " + se.getSource() + " " + se.getValue());

	}

}
