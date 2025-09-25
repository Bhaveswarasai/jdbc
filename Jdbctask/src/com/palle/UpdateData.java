package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJEEAUG","root","admin");
		
		PreparedStatement pt = cn.prepareStatement("update Student set COUSRSE = ?  where STID = ?");
		
		pt.setString(1, "Hibernet");
		pt.setInt(2,103);
		
		 int rows = pt.executeUpdate();		
		 
		 
		System.out.println(rows);
		
		pt.close();
		cn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
