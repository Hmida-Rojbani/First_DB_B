package de.tekup.db.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getOnefromDB(@PathVariable int id){
		return empService.getEmployeeById(id);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
		//										, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							 .body("Error in Employee : " + e.getMessage());
	}
}
