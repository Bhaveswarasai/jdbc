package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class Insertdata {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBJEEAUG ", "root", "admin");

			PreparedStatement pt = con.prepareStatement("insert into Student values(? , ? , ?)");

			pt.setInt(1, 103);
			pt.setString(2, "EFCODE");
			pt.setString(3, "RDBMS");

			int rows = pt.executeUpdate();

			System.out.println(rows);
			con.close();
			pt.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
