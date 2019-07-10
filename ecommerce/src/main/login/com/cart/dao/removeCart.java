package com.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class removeCart {
	public void remCart(String username,int id) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
			
			Statement st = con.createStatement();			
			st.executeUpdate("delete from cart where username='"+username+"' and productid='"+id+"'");
		}
		catch(Exception e) {
			
		}	
		
	}
}
