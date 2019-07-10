package com.cart.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class cartDao {
	public int addCart(String username,int id,String name,double price,int quantity) {
		
		int rowcount=0;
		try {
			double total = price*quantity;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
			
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from cart where productid='"+id+"' and username='"+username+"'");  
			
			
			if(rs.next()) {
				rowcount=st.executeUpdate("update cart set productquantity='"+quantity+"', productprice='"+total+"' where username='"+username+"' and productid='"+id+"'");
			}
			else
			{
				rowcount=st.executeUpdate("INSERT INTO cart VALUES ('"+username+"','"+id+"', '"+name+"', '"+total+"', '"+quantity+"')");

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return rowcount;
		
	}
}
