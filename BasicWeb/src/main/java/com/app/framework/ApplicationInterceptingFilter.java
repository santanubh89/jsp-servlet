package com.app.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplicationInterceptingFilter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		System.out.println("Initializing Filter " + config.getFilterName());
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		boolean authenticated = false;
		System.out.println("Servlet Path: " + httpRequest.getServletPath() + " " + httpRequest.getDispatcherType());
		if (httpRequest.getServletPath().equals("/Login.jsp") || httpRequest.getServletPath().equals("/ValidateLogin")
				|| httpRequest.getServletPath().contains("/sayhello")) {
			authenticated = true;
		} else {
			authenticated = authenticateSession(httpRequest);
		}
		if (authenticated) {
			System.out.println("Config Init Param value : " + config.getInitParameter("filter-param-name-1"));
			System.out.println("Servlet Context : " + config.getServletContext().getServerInfo());
			request.setAttribute("filter-attribute", "This attribute is set in filter");
			chain.doFilter(request, response);
			Cookie cookie = new Cookie("userdetail", "santanu");
			cookie.setMaxAge(30);
			httpResponse.addCookie(cookie);
			System.out.println("Returning Response to Browser...");
		} else {
			/*
			 * request.getRequestDispatcher("/Login.jsp").forward(request,
			 * response);
			 */
			httpResponse.sendRedirect("Login.jsp");
			// return;
		}
	}

	private boolean authenticateSession(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (null != session && null != session.getAttribute("loginuser")) {
			return true;
		} else {
			return false;
		}

	}

	public void destroy() {
		System.out.println("Destroying Filter...");
	}
}