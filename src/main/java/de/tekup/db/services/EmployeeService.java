package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository empRepos;

	//SQL : insert
	public EmployeeEntity addEmployeeToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}
	
	//SQL : select * from table
	public List<EmployeeEntity> getAllEmployees(){
		return empRepos.findAll();
	}
	
	//SQL : select * from table where id = id
		public EmployeeEntity getEmployeeById(int id){
			Optional<EmployeeEntity> opt = empRepos.findById(id);
//			if(opt.isPresent())
//				return opt.get();
//			throw new NoSuchElementException("Employee with this id is not found");
			
			return opt.orElseThrow(()->new NoSuchElementException("Employee with this id is not found"));
		}
		
		// SQL : update 
		public EmployeeEntity updateEmployeeById(int id, EmployeeEntity newEmployee) {
			EmployeeEntity employee = getEmployeeById(id);
			//search elements to change
			if(newEmployee.getName()!=null)
				employee.setName(newEmployee.getName());
			if(newEmployee.getEmail()!=null)
				employee.setEmail(newEmployee.getEmail());
			if(newEmployee.getDob()!=null)
				employee.setDob(newEmployee.getDob());
			
			return empRepos.save(employee);
		}
}
