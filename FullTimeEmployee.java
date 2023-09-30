package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FullTimeEmployee extends Employee{
	private double monthlySalary;
	private int days;
	private double oneDaySalary;
	private int id;
	
	public FullTimeEmployee(String name,int days,int id) {
		super(name);
		this.days=days;
		this.id=id;
		PayrollSystem p1=new PayrollSystem();
		p1.addFullTimeEmployee(name, monthlySalary,id);
	}

	@Override
	public double calculateSalary() {
		try {
			Connection con=CP.createC();
			String q="SELECT * FROM employee where id='"+this.id+"'";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
			this.monthlySalary=rs.getDouble("monthly_Salary");
		    this.oneDaySalary=this.monthlySalary/31;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		 return this.days*this.oneDaySalary;
	}
}