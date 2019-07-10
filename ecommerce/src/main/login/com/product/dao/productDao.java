package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.model.productModel;
public class productDao {
	
	
	public List<productModel> getProduct() {
		List<productModel> productlist = new ArrayList<productModel>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from product");
		
		while(rs.next()) {
			productlist.add(new productModel(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(4)));
		}
		
	}
	catch(Exception e) {
		
	}
	return productlist;
	}
}
