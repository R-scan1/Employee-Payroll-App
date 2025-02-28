package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<Employee> employeeList = new ArrayList<>();
    private int employeeIdCounter = 1; 

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeIdCounter++, employeeDTO);
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(long id) {
        return employeeList.stream()
            .filter(employee -> employee.getEmployeeId() == id)
            .findFirst()
            .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            employee.setGender(employeeDTO.getGender());
            employee.setStartDate(employeeDTO.getStartDate());
            employee.setNote(employeeDTO.getNote());
            employee.setProfilePic(employeeDTO.getProfilePic());
            employee.setDepartments(employeeDTO.getDepartment());
        }
        return employee;
    }

    public boolean deleteEmployee(long id) {
        return employeeList.removeIf(employee -> employee.getEmployeeId() == id);
    }
}
