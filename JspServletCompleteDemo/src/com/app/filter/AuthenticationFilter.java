package com.app.filter;

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

public class AuthenticationFilter implements Filter {
	
	private FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Initializing Filter "+config.getFilterName());
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Config Init Param value : "+config.getInitParameter("filter-param-name-1"));
		System.out.println("The path is : "+((HttpServletRequest)request).getServletPath());
		request.setAttribute("attr1", "attr-value-1");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		HttpSession session = httpRequest.getSession();
		String authenticatedUser = (String) session.getAttribute("username");
		String servletPath = httpRequest.getServletPath();
		if (servletPath.equals("/Login.jsp") || servletPath.equals("/login")) {
			filterChain.doFilter(httpRequest, response);
		} else if (authenticatedUser == null) {
			httpResponse.sendRedirect("Login.jsp");
		} else if (authenticatedUser != null) {
			filterChain.doFilter(httpRequest, response);
		}
		Cookie cookie = new Cookie("userdetail", "santanu");
		cookie.setMaxAge(30);
		((HttpServletResponse)response).addCookie(cookie);
		System.out.println("Filtering done...");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying Filter...");
	}

}
