package com.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet(name = "Calculator", urlPatterns = { "/Calculator" })
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.valueOf(request.getParameter("n1"));
		int n2 = Integer.valueOf(request.getParameter("n2"));
		String operation = request.getParameter("operation");
		if (n1 ==0 || n2 == 0) {
			throw new ServletException ("Invalid Number");
		}
		int result = 0;
		if (operation.equals("sum")) {
			result = n1+n2;
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("Hello.jsp").forward(request, response);
	}

}
