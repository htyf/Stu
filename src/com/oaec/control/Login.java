package com.oaec.control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "root";
		String password = "root";
		
		if("root".equals(username) && "root".equals(password)){
			HttpSession s = request.getSession();
			s.setAttribute("aaa", "bbb");
			request.setAttribute("ccc", "dddddddd");
			this.getServletContext().setAttribute("ggggggg", "ffffffffff");
			request.getRequestDispatcher("loginOk.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
