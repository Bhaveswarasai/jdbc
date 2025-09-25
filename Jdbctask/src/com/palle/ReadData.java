package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJEEAUG", "root", "admin");
			
			 PreparedStatement pst = con.prepareStatement("SELECT * from student");
			 
			 ResultSet rs = pst.executeQuery();
			 
			 while(rs.next()) {
				 System.out.println(rs.getInt(1));
				 System.out.println(rs.getString(2));
				 System.out.println(rs.getString(3));
				 System.out.println("------------------------");
			 }
			  
			 
			rs.close();
			pst.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
