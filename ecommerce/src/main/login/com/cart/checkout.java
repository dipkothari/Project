package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.cartpDao;
import com.cart.dao.checkoutDao;
import com.cart.model.cartModel;

public class checkout extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		checkoutDao cd = new checkoutDao();
		String msg = cd.checkout(username);
		if(msg.equals("Sorry")) {
			request.setAttribute("insufficient", "Sorry item you selected is in less quantity");
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		}
		else {
		cartpDao cr = new cartpDao();
		List<cartModel> cm = cr.getProduct(username);
		session.setAttribute("cart", cm);
		response.sendRedirect("cart.jsp");
		}
	}

}
