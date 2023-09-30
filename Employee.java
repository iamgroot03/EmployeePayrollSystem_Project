package com.demo.main;

abstract class Employee {
	
	private int id;
	private String name;
	private String address;
	private String salary_type;
	private double salary;
	
	
   public Employee( String name, String address, String salary_type, double salary) {
		super();
		this.name = name;
		this.address = address;
		this.salary_type = salary_type;
		this.salary = salary;
	}
   public Employee( String name) {
		super();
		this.name = name;
	}
   
   public Employee( String name,int id) {
		super();
		this.name = name;
		this.id=id;
	}
  
   

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary_type() {
		return salary_type;
	}

	public void setSalary_type(String salary_type) {
		this.salary_type = salary_type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

public abstract double calculateSalary();
	

}
