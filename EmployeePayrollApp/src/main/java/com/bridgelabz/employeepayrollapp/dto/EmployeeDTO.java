package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	@NotEmpty(message="Employee name cannot be null")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;
	
	@Min(value=500, message = "Min Wage should be more than 500")
    private double salary;

	
}
