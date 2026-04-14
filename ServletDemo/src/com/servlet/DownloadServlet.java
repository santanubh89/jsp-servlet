package com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownloadServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Initializing Servlet: "+config.getServletName());
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get in Download Servlet Called..");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		//response.setHeader("Content-Disposition","attachment;filename=downloadname.txt");
		response.setHeader("Content-Disposition","attachment;");
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("./filestore/BDA- Certificate in Telecom Billing.pdf");
		int read = 0;
		byte[] bytes = new byte[8192];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}

}
