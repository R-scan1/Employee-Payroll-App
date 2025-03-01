package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayrollapp.model.*;

public interface EmployeePayrollRepository extends JpaRepository<Employee,Integer>{

}
