package com.bridgelabz.employeepayrollapp.model;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import lombok.Data;

public @Data class Employee {
	
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
    

    public Employee() {}
    
    public Employee(int empId,EmployeeDTO employeedto) {
        this.employeeId=empId;
        this.name=employeedto.name;
        this.salary=employeedto.salary;
        this.gender=employeedto.gender;
        this.note=employeedto.note;
        this.startDate=employeedto.startDate;
        this.profilePic=employeedto.profilePic;
        this.departments=employeedto.department;
    }
    
    
}
