package com.cart;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.cartDao;

public class addServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
					int id = Integer.parseInt(request.getParameter("productid"));
					String name = request.getParameter("productname");
					double price = Double.parseDouble(request.getParameter("productprice"));
					int quantity = Integer.parseInt(request.getParameter("productquantity"));
					cartDao cd = new cartDao();
					
					HttpSession session = request.getSession();
					String username = (String) session.getAttribute("username");
					
					cd.addCart(username, id,name,price,quantity);
					response.sendRedirect("product.jsp");
		
			}

}
