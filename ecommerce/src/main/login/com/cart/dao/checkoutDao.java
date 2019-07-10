package com.cart.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class checkoutDao {
	public String checkout(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
			
			Statement st = con.createStatement();		
			ResultSet rs = st.executeQuery("select * from cart where username='"+username+"'");

			while(rs.next()) {
				int cartcount = rs.getInt(5);
				int cartid = rs.getInt(2);
				Statement st1 = con.createStatement();
				ResultSet rs1 = st1.executeQuery("select * from product where productid='"+cartid+"'");
				if(rs1.next()) {
					int productcount = rs1.getInt(4);
					
					int totalcount = productcount-cartcount;
					if(totalcount>=0) {
					Statement st2 = con.createStatement();
					st2.executeUpdate("update product set productquantity='"+totalcount+"' where productid ='"+cartid+"'");
					}
					
					else {
						return "Sorry";
					}
					
				}
			}
			Statement st3 = con.createStatement();
			st3.executeUpdate("delete from cart where username='"+username+"'"); 
			
			
		}
		catch(Exception e) {
			
		}
		return username;
	}
}
