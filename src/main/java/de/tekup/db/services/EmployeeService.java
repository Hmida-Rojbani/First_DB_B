package de.tekup.db.services;

import java.util.List;

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
}
