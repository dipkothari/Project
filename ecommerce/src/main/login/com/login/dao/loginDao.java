package com.login.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class loginDao {
	
		
		
		public boolean check(String name, String pass) throws SQLException, ClassNotFoundException {
			
			Connection con = null;
			PreparedStatement st = null;
			ResultSet re = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","Assignment","Assignment");
				
			st = con.prepareStatement("select * from deep.check where uname=? and pass=?");
				
				st.setString(1,name);
				st.setString(2,pass);
				
				 re = st.executeQuery();
				
				
				if(re.next()) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
				return false;
	
		}
}
