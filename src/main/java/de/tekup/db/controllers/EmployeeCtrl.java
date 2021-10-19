package de.tekup.db.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/employee/get/name/{name}")
	public EmployeeEntity getOneByNamefromDB(@PathVariable String name){
		return empService.getEmployeeByName(name);
	}
	@GetMapping("/employee/get/date/{date}")
	public List<EmployeeEntity> getAllByDatefromDB(@PathVariable String date){
		LocalDate d = LocalDate.parse(date);
		return empService.getEmployeesAfterDob(d);
	}
	
	@PutMapping("/employee/update/{id}")
	public EmployeeEntity updateOnefromDB(@PathVariable int id,@RequestBody EmployeeEntity employeeEntity){
		return empService.updateEmployeeById(id, employeeEntity);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public EmployeeEntity deleteOnefromDB(@PathVariable int id){
		return empService.deleteEmployeeById(id);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
		//										, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							 .body("Error in Employee : " + e.getMessage());
	}
}
