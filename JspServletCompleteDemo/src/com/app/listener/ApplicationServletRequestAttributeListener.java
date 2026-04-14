package com.app.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ApplicationServletRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// System.out.println("A new servlet request attribute added: " + srae.getName() + " " + srae.getSource() + " " + srae.getValue());

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// System.out.println("A new servlet request attribute removed: " + srae.getName() + " " + srae.getSource() + " " + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// System.out.println("A new servlet request attribute replaced: " + srae.getName() + " " + srae.getSource() + " "+ srae.getValue());

	}

}
