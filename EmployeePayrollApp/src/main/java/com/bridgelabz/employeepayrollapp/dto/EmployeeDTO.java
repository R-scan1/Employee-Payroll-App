package com.bridgelabz.employeepayrollapp.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public @ToString class EmployeeDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
	
	@Min(value=500, message = "Min Wage should be more than 500")
    public long salary;
	
    public String gender;
    
    public String startDate;
    
    public String note;
    
    public String profilePic;
    
    public List<String> department;
}
