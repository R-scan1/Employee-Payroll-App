package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Service
public class EmployeePayrollService {

    private List<Employee> employeeList = new CopyOnWriteArrayList<>(); // Thread-safe list
    private int employeeIdCounter = 1;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeIdCounter++, employeeDTO);
        employeeList.add(newEmployee);
        log.info("Created Employee: {}", newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(long id) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found with ID: " + id));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id); 

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartments(employeeDTO.getDepartments());

        log.info("Updated Employee: {}", employee);
        return employee;
    }

    public void deleteEmployee(long id) {
        boolean removed = employeeList.removeIf(employee -> employee.getEmployeeId() == id);
        if (!removed) {
            throw new EmployeePayrollException("Cannot delete. Employee Not Found with ID: " + id);
        }
        log.info("Deleted Employee with ID: {}", id);
    }
}
