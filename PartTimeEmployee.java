package com.demo.main;

public class PartTimeEmployee extends Employee{
	private int hoursWork;
	private double hoursRate;
	
	public PartTimeEmployee(String name,int hoursWork,double hoursRate,int id) {
		super(name);
		this.hoursWork=hoursWork;
		this.hoursRate=hoursRate;
		double salary=calculateSalary();
	    PayrollSystem ps=new PayrollSystem();
	    ps.addPartTimeEmployee(name, salary, id);
	    System.out.println("Doneee");
		
	}
	
	@Override
	public double calculateSalary() {
		return hoursWork*hoursRate;
	}

}
