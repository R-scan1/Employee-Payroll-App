package com.bridgelabz.employeepayrollapp.model;

public class Employee {
	
    private static long idCounter=1;
	private long id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.id=idCounter;
        idCounter++;
    	this.name = name;
        this.salary = salary;
    }
    
    public long getId(){
    	return id;
    	}
    public void setId(long id){
    	this.id = id; 
    	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
