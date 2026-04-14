package com.app.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ApplicationServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// System.out.println("A new servlet context attribute added: " + scae.getName() + " " + scae.getSource() + " " + scae.getValue());

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// System.out.println("A new servlet context attribute removed: " + scae.getName() + " " + scae.getSource() + " " + scae.getValue());

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// System.out.println("A new servlet context attribute replaced: " + scae.getName() + " " + scae.getSource() + " " + scae.getValue());

	}

}
