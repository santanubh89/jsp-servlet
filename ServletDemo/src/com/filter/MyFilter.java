package com.filter;

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

public class MyFilter implements Filter {
	
	private FilterConfig config;
	
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Initializing Filter "+config.getFilterName());
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtering started...");
		System.out.println("Config Init Param value : "+config.getInitParameter("filter-param-name-1"));
		System.out.println("Servlet Context : "+config.getServletContext().getServerInfo());
		System.out.println("The path is : "+((HttpServletRequest)request).getServletPath());
		System.out.println("Dispatcher: "+request.getDispatcherType());
		request.setAttribute("attr1", "attr-value-1");
		chain.doFilter(request, response);
		Cookie cookie = new Cookie("userdetail", "santanu");
		cookie.setMaxAge(30);
		((HttpServletResponse)response).addCookie(cookie);
		System.out.println("Filtering done...");
	}

	public void destroy() {
		System.out.println("Destroying Filter...");
	}
}