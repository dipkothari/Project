package com.login;

import java.io.IOException;



import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.loginDao;



public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		loginDao dao = new loginDao();
			
			
			try {
				
				if(dao.check(name, pass)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", name);
					RequestDispatcher rd = request.getRequestDispatcher("Product");
					rd.forward(request, response);
				}
				else {
					response.sendRedirect("login.jsp");
				}
			} 
			catch(Exception e) {
				
			}
		
	}
		
		
		
	}


	

