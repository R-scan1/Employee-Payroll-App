package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService {

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getName(), employeeDTO.getSalary());
    }
}
