package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Runtime_crud {
    
    public static void insert(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Course:");
        String course = sc.nextLine();

        String sql = "INSERT INTO student (id, name, age, course) VALUES (?, ?, ?, ?)";
        try (var pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, course);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Insert successful.");
            } else {
                System.out.println("Insert failed.");
            }
        }
    }

    public static void read(Connection con) throws SQLException {
        String sql = "SELECT * FROM student";  
        try (var stmt = con.createStatement();
             var rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course);
            }
        }
    }

    public static void update(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the ID of the student to update:");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.println("Enter new Name:");
        String name = sc.nextLine();
        System.out.println("Enter new Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Course:");
        String course = sc.nextLine();

        String sql = "UPDATE student SET name = ?, age = ?, course = ? WHERE id = ?";
        try (var pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, course);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No record found with this ID.");
            }
        }
    }

    public static void delete(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the ID of the student to delete:");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline

        String sql = "DELETE FROM student WHERE id = ?";
        try (var pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Delete successful.");
            } else {
                System.out.println("No record found with this ID.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/revision", "root", "admin");
            while(true){
                System.out.println("Please choose an operation");
                System.out.println("1) Insert");
                System.out.println("2) Read");
                System.out.println("3) Update");
                System.out.println("4) Delete");
                System.out.println("5) Exit");
                int num = sc.nextInt();
                System.out.println();

                if(num == 5) {
                    System.out.println("Thanks for using, visit again.");
                    break;
                }
                switch(num) {
                    case 1:
                        insert(con, sc);
                        break;
                    case 2:
                        read(con);
                        break;
                    case 3:
                        update(con, sc);
                        break;
                    case 4:
                        delete(con, sc);
                        break;
                    default:
                        System.out.println("Select correct option\n");
                }
            }
            con.close();
            sc.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
