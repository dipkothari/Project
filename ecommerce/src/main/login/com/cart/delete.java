package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.cartpDao;
import com.cart.dao.removeCart;
import com.cart.model.cartModel;


public class delete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("productid"));
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		removeCart cd = new removeCart();
		cd.remCart(username,id);
		cartpDao cd1 = new cartpDao();
		List<cartModel> cm = cd1.getProduct(username);
	
		
		
		session.setAttribute("cart", cm);
		
		response.sendRedirect("cart.jsp");

	}
}
