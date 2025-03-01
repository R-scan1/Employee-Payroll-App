package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Autowired
	private EmployeePayrollRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = null;
        newEmployee=new Employee(employeeDTO);
        log.debug("Emp Data: "+newEmployee.toString());
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department){
    	return employeeRepository.findEmployeeByDepartment(department);
    }
    
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new EmployeePayrollException("Employee with employeeID "+id+" does not exists..!!"));
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = this.getEmployeeById(id); 
        employee.updateEmployee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee empData=this.getEmployeeById(id);
        employeeRepository.delete(empData);
    }
}
