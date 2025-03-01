package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeePayrollService.createEmployee(employeeDTO);
        ResponseDTO response = new ResponseDTO("Employee created successfully", employee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        List<Employee> employeeList = employeePayrollService.getAllEmployees();
        ResponseDTO response = new ResponseDTO("List of all employees", employeeList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeePayrollService.getEmployeeById(id);
        ResponseDTO response = new ResponseDTO("Employee details for ID: " + id, employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable("department")String department){
    	List<Employee> empDataList=null;
    	empDataList=employeePayrollService.getEmployeesByDepartment(department);
    	ResponseDTO respDTO=new ResponseDTO("Get Call For ID Successful",empDataList);
    	return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("id") int id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeePayrollService.updateEmployee(id, employeeDTO);
        ResponseDTO response = new ResponseDTO("Employee updated successfully", updatedEmployee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("id") int id) {
        employeePayrollService.deleteEmployee(id);
        ResponseDTO response = new ResponseDTO("Employee deleted successfully", "Employee ID: " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
