package de.tekup.db.services;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository empRepos;

	public EmployeeEntity addEmployeeToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}

}
