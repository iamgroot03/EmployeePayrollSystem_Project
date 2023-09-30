package com.demo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
	static Connection con;
	 
	 public static Connection createC() throws ClassNotFoundException, SQLException {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3307/new_employee_payroll","root","");

		 return con;

	 }
}
