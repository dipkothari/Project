package com.cart.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cart.model.cartModel;




public class cartpDao {
	public List<cartModel> getProduct(String username) {
	List<cartModel> cartlist = new ArrayList<cartModel>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from cart where username='"+username+"'");
		
		while(rs.next()) {
			cartlist.add(new cartModel(rs.getString(1),rs.getInt(2), rs.getString(3), rs.getDouble(4),rs.getInt(5)));
		}
		
	}
	catch(Exception e) {
		
	}
	return cartlist;
	}
}
