package com.app.framework;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ApplicationStateChangeListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener,
		ServletContextAttributeListener, ServletRequestListener, ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("An existing servlet request is destroyed... "+sre.getServletRequest());
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("A new servlet request is created... "+sre.getServletRequest());
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("An HTTP session attribute has been created... "+se.getName()+" "+se.getValue()+" "+se.getSource());
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("An HTTP session attribute has been removed... "+se.getName()+" "+se.getValue()+" "+se.getSource());
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("An HTTP session attribute has been replaced... "+se.getName()+" "+se.getValue()+" "+se.getSource());
	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("A New session is created: "+se.getSource());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("An existing session is destroyed: "+se.getSource());
	}

	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("A ServletContextAttribute has been added... "+scae.getName()+" "+scae.getValue()+" "+scae.getSource());
	}

	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("A ServletContextAttribute has been removed... "+scae.getName()+" "+scae.getValue()+" "+scae.getSource());
	}

	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("A ServletContextAttribute has been replaced... "+scae.getName()+" "+scae.getValue()+" "+scae.getSource());
	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Servlet context has been destroyed... "+event.getSource());
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Servlet context has been initialized... "+event.getSource());
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("A servlet request attribute has been created... "+srae.getName()+" "+srae.getValue()+" "+srae.getSource());
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("A servlet request attribute has been removed... "+srae.getName()+" "+srae.getValue()+" "+srae.getSource());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("A servlet request attribute has been replaced... "+srae.getName()+" "+srae.getValue()+" "+srae.getSource());
	}
}
