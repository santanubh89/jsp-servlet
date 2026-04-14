package com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.UserModel;
import com.app.service.AuthenticationService;

public class AuthenticationController extends HttpServlet {
	
	public AuthenticationController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AuthenticationService service = new AuthenticationService();
		boolean authenticated = service.authenticate(username, password);
		if (authenticated) {
			session.setAttribute("username", username);
			UserModel user = service.getUser(username, password);
			if (null!= user) {
				session.setAttribute("userinfo", user);
				request.setAttribute("userinfo", user);
				request.setAttribute("greetingMessage", user.getUserName()+" says hello!");
				request.setAttribute("associatedUsers", getUsers());
				Cookie cookie = new Cookie("username", username+"fromookie");
				response.addCookie(cookie);
			}
			// response.sendRedirect("Greeting.jsp");
			request.getRequestDispatcher("Greeting.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
	}
	
	private List<UserModel> getUsers(){
		return Arrays.asList(new UserModel("1", "name 1", "city 1", "state 1", "pin 1"),
				new UserModel("2", "name 2", "city 2", "state 2", "pin 4"),
				new UserModel("3", "name 3", "city 3", "state 3", "pin 3"),
				new UserModel("4", "name 4", "city 4", "state 4", "pin 4"));
	}

}
