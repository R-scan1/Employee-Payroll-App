package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public String getAllEmployees() {
        return "Getting all employees!";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable("id") Long id) {
        return "Getting employee with ID: " + id;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.createEmployee(employeeDTO);
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employee) {
        return "Employee updated with details: " + employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return "Employee with ID " + id + " deleted.";
    }
}
