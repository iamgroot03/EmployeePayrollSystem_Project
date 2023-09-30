package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		PayrollSystem ps=new PayrollSystem();
		try (Scanner sc = new Scanner(System.in)) {
			while(true){
				System.out.println("********* Admin *****************");
				System.out.println("Press 1 for Registration");
				System.out.println("Press 2 for Login");
				System.out.println("Press 3 for Exit");
				System.out.print("Press the Number:");
				int c1=sc.nextInt();
				if(c1==1) {
					System.out.print("Enter Name:");
					String name=sc.next();
					System.out.print("Enter Email:");
					String email=sc.next();
					System.out.print("Enter password:");
					String password=sc.next();
					Admin a=new Admin(name,email,password);
					


					
				}
				else if(c1==2) {
					System.out.print("ENTER THE EMAIL:");
			    	String email=sc.next();
			    	System.out.print("ENTER THE PASSWORD:");
			    	String password=sc.next();
			    	System.out.println("*******************************************************");
			    	
			    	try {
				    	Connection con=CP.createC();
						String q="SELECT * FROM admin WHERE email = '"+email+"' AND password = '"+password+"'";
						Admin u=new Admin(email,password);
						PreparedStatement psmt=con.prepareStatement(q);
						boolean row=psmt.execute();
						
				        if(row){
				        	System.out.println("Login successfully..");
				        	while(true) {
				        		System.out.println("Press 1 for Add Employee");
				    			System.out.println("Press 2 for Calculate Part Time Employee Salary");
				    			System.out.println("Press 3 for Calculate Full Time Employee Salary");
				    			System.out.println("Press 4 for Show Employee salary Details");
				    			System.out.println("Press 5 for Show Employee Details");
				    			System.out.println("Press 6 for Detele Employee");
				    			System.out.println("Press 7 for Exit");
				    			System.out.println("************************************************************");
				    			System.out.print("Press the Number:");
				    			int c2=sc.nextInt();
				    		
				    			
				    			
				    			if(c2==1) {
				    				System.out.print("Enter Employee Name:");
				    				String name=sc.next();
				    				System.out.print("Enter Employee Adress:");
				    				String address=sc.next();

				    				System.out.print("Enter Salary Type (FullTime Or PartTime) :");
				    				String salaryType=sc.next();
				    				
				    				//if partTime employee add so Enter 0...............
				    				System.out.print("Enter Month Salary");
				    				Double salary=sc.nextDouble();
				    				System.out.println("************************************************************");
				    				ps.addEmployee(name, address, salaryType, salary);
				    				
				    	
				    				
				    				
				    			}
				    			else if(c2==2) {
				    				System.out.print("Enter Employee id:");
				    				int id=sc.nextInt();
				    				System.out.print("Enter Employee Name:");
				    				String name=sc.next();
				    				System.out.print("Enter Hours of Work :");
				    				int hoursWork=sc.nextInt();
				    				System.out.print("Enter Per Hours Rate:");
				    				Double hoursRate=sc.nextDouble();
				    				System.out.println("************************************************************");
				    				PartTimeEmployee pt=new PartTimeEmployee(name, hoursWork,hoursRate,id);
				    		
				    				
				    				
				    			}
				    			else if(c2==3) {
				    				System.out.print("Enter Employee id:");
				    				int id=sc.nextInt();
				    				System.out.print("Enter Employee Name:");
				    				String name=sc.next();
				    				System.out.print("Enter present days in company");
				    				int days=sc.nextInt();
				    				System.out.println("************************************************************");
				    				FullTimeEmployee pt=new FullTimeEmployee(name, days,id);
				    				
				    			}
				    			else if(c2==4) {
				    				ps.employeeSalaryDetails();
				    				
				    			}
				    			else if(c2==5) {
				    				ps.employeeDetails();
				    			}
				    			else if(c2==6) {
				    				System.out.print("Enter Delete Employee id:");
				    				int id=sc.nextInt();
				    				ps.deleteEmployee(id);
				    			}
				    			else if(c2==7) {
				    				break;
				    			}
				    			
				        	}
				        }
				        	
				        }catch (Exception e) {
							System.out.println(e);
						}
				}
				else if(c1==3) {
					break;
				}
				
			}
		}
	}

}
