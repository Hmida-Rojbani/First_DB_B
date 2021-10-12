package de.tekup.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.services.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeCtrl {
	private  EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveToDB(@RequestBody EmployeeEntity employeeEntity) {
		//call of service
		return empService.addEmployeeToDB(employeeEntity);
	}
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllfromDB(){
		return empService.getAllEmployees();
	}

}
