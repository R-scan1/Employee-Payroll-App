package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="employee_payroll")
public @Data class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
    private int employeeId;
	
	@Column(name="name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    
    
    @ElementCollection
    @CollectionTable(name="employee_department", joinColumns=@JoinColumn(name="employee_id"))
    @Column(name="department")
    private List<String> department;
    

    public Employee() {}
    
    public Employee(EmployeeDTO employeedto) {
    	this.updateEmployee(employeedto);
    }
    
    public void updateEmployee(EmployeeDTO employeedto) {
    	this.name=employeedto.name;
        this.salary=employeedto.salary;
        this.gender=employeedto.gender;
        this.note=employeedto.note;
        this.startDate=employeedto.startDate;
        this.profilePic=employeedto.profilePic;
        this.department=employeedto.department;
    }
    
    
}
