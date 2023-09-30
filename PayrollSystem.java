package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class PayrollSystem {
	public void addEmployee(String name,String address,String salaryType,double salary) {
		 try {
				Connection con=CP.createC();
				String q="insert into employee(name,address,salary_status,monthly_salary) values('"+name+"','"+address+"','"+salaryType+"','"+salary+"') ";
				PreparedStatement psmt=con.prepareStatement(q);
				int row=psmt.executeUpdate();
		        if(row>0){
		            System.out.println("Employee Add successfully...");
		            System.out.println("************************************************************");
		  
		        }
		        else {
		            System.out.println("Something went wrong");
		        }
				
			} 
	     catch (Exception e) {
				e.printStackTrace();
			}
	
	
}
	
	public void addPartTimeEmployee(String name,double salary,int id) {
		int emp_id;
		String emp_name;
		String emp_address;
		String emp_salaryStatus;
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now();
		 String date=dtf.format(now);
		
		
		try {
			Connection con=CP.createC();
			String q="SELECT * FROM employee where id='"+id+"'";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			System.out.println("************************************************************");
			while(rs.next()) {
				emp_id=rs.getInt("id");
				emp_name=("name");
				emp_address=rs.getString("address");
				emp_salaryStatus=rs.getString("salary_status");
				
				String q2="insert into payroll_system(name,address,salary,date_time,id_no,salary_status) values('"+emp_name+"','"+emp_address+"','"+salary+"','"+date+"','"+emp_id+"','"+emp_salaryStatus+"') ";
				PreparedStatement psmt2=con.prepareStatement(q2);
				int row=psmt2.executeUpdate();
				  if(row>0){
			            System.out.println("Salary Data Add successfully...");
			            System.out.println("************************************************************");
			  
			        }
			        else {
			            System.out.println("Something went wrong");
			        }
			}
			
			
		}catch (Exception e) {
		System.out.println(e);
		System.out.println("Somethig Wrong");
		}
	
}
	
	public void addFullTimeEmployee(String name,double salary,int id) {
		int emp_id;
		String emp_name;
		String emp_address;
		String emp_salaryStatus;
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now();
		 String date=dtf.format(now);
		
		try {
			Connection con=CP.createC();
			String q="SELECT * FROM employee where id='"+id+"'";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			System.out.println("************************************************************");
			while(rs.next()) {
				emp_id=rs.getInt("id");
				emp_name=rs.getString("name");
				emp_address=rs.getString("address");
				emp_salaryStatus=rs.getString("salary_status");
				
				String q2="insert into payroll_system(name,address,salary,date_time,id_no,salary_status) values('"+emp_name+"','"+emp_address+"','"+salary+"','"+date+"','"+emp_id+"','"+emp_salaryStatus+"') ";
				PreparedStatement psmt2=con.prepareStatement(q2);
				int row=psmt2.executeUpdate();
				  if(row>0){
			            System.out.println("Salary Data Add successfully...");
			            System.out.println("************************************************************");
			  
			        }
			        else {
			            System.out.println("Something went wrong");
			        }
			}
			
			
		}catch (Exception e) {
		System.out.println(e);
		}
	
}
	
	public void employeeDetails() {
		try {
	    	Connection con=CP.createC();
			String q="SELECT * FROM employee";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			System.out.println("************************************************************");
			while(rs.next()) {
				System.out.println("ID         :"+rs.getInt("id"));
				System.out.println("Name       :"+rs.getString("name"));
				System.out.println("address    :"+rs.getString("address"));
				System.out.println("Salary     :"+rs.getDouble("monthly_salary"));
				System.out.println("Job Status :"+rs.getString("salary_status"));
				System.out.println("--------------------------------------------------------");
			
			}
			System.out.println("************************************************************");
		
	}catch (Exception e) {
		System.out.println(e);
	}
	}

	public void employeeSalaryDetails() {
		try {
	    	Connection con=CP.createC();
			String q="SELECT * FROM payroll_system";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("NO :"+rs.getInt("no")+" "+"(Name :"+rs.getString("name")+"),"+"(address:"+rs.getString("address")+"),"+"(Salary:"+rs.getDouble("salary")+"),"+"(ID NO:"+rs.getString("id_no")+"),"+"(Salary Status:"+rs.getString("salary_status")+"),"+"(Data Time :"+rs.getString("date_time")+")");	
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
				
//				System.out.println("NO           :"+rs.getInt("no"));
//				System.out.println("Name         :"+rs.getString("name"));
//				System.out.println("address      :"+rs.getString("address"));
//				System.out.println("Salary       :"+rs.getDouble("salary"));
//				System.out.println("ID NO        :"+rs.getString("id_no"));
//				System.out.println("Salary Status:"+rs.getString("salary_status"));
//				System.out.println("Data Time    :"+rs.getString("date_time"));
//				System.out.println("--------------------------------------------------------");
			
			}
			System.out.println("************************************************************");
		
	}catch (Exception e) {
		System.out.println(e);
	}
		
	}
	
	public void deleteEmployee(int id) {
		try {
			//deleted Record collect in 
			Connection con=CP.createC();
			String q="SELECT * FROM employee where id='"+id+"'";
			PreparedStatement psmt=con.prepareStatement(q);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
		    int emp_id=rs.getInt("id");
			String	emp_name=rs.getString("name");
			String	emp_address=rs.getString("address");
			String	emp_salaryStatus=rs.getString("salary_status");
			double emp_monthlySalary=rs.getDouble("monthly_salary");
			
			String q2="insert into deleted_employee(emp_id,name,address,salary_status,monthly_salary) values('"+emp_id+"','"+emp_name+"','"+emp_address+"','"+emp_salaryStatus+"','"+emp_monthlySalary+"') ";
			PreparedStatement statement=con.prepareStatement(q2);
			statement.executeUpdate();
			
			}
			String q3="DELETE FROM employee WHERE id='"+id+"'";
			PreparedStatement psmt3=con.prepareStatement(q3);
			int row=psmt3.executeUpdate();
	        if(row>0){
	            System.out.println("Employee deleted successfully...");
	            System.out.println("************************************************************");
	  
	        }
	        else {
	            System.out.println("Something went wrong");
	        }
			
		} 
     catch (Exception e) {
			System.out.println(e);
		}
					
		

		
	}

	
	
	

}
