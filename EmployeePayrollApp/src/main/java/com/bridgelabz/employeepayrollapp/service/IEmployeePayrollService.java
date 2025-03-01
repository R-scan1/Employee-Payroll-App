package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    Employee createEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(long id, EmployeeDTO employeeDTO);
    void deleteEmployee(long id);
}
