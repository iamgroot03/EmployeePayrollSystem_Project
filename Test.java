package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
	public static void main(String[] args) {
		 double monthlySalary;
		 double oneDaySalary = 0;
		try {
			Connection con=CP.createC();
			String q="SELECT * FROM employee where id='"+1+"'";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			System.out.println("************************************************************");
			while(rs.next()) {
			monthlySalary=rs.getDouble("monthly_Salary");
			System.out.println(rs.getDouble("monthly_Salary"));
		    oneDaySalary=monthlySalary/31;
			}
		}catch (Exception e) {
	
		}
		
		
		
		System.out.println(oneDaySalary);
		System.out.println(oneDaySalary*30);
	}

}
