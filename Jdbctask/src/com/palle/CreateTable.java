package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			step 1: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

//		step 2: Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJEEAUG", "root", "admin");

//		step 3:prepare SQl statement
			Statement st = con.createStatement();

//		 step 4: excute query
			int rowseffected = st
					.executeUpdate("create table Student (STID INT , STNAME VARCHAR(40) , COUSRSE VARCHAR(40))");

			System.out.println("TAble creation is successful");
			System.out.println(rowseffected);
// step 5: close resources
			con.close();
			st.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
