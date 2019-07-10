package com.product;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.dao.productDao;
import com.product.model.productModel;


public class Product extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.getAttribute("username");
		productDao pd = new productDao();
		
		List<productModel> pm = pd.getProduct();
		session.setAttribute("product", pm);
		response.sendRedirect("product.jsp");
	}

	

}
