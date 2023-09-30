package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Admin {
	private int id;
	private String name;
	private String email;
	private String password;
	
	public Admin( String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		
		 try {
				Connection con=CP.createC();
				String q="insert into admin(name,email,password) values('"+name+"','"+email+"','"+password+"') ";
				PreparedStatement psmt=con.prepareStatement(q);
				int row=psmt.executeUpdate();
		        if(row>0){
		            System.out.println("Registraction successfully...");
		  
		        }
		        else {
		            System.out.println("Something went wrong");
		        }
				
			} 
	     catch (Exception e) {
				e.printStackTrace();
			}
	}

	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	


}
