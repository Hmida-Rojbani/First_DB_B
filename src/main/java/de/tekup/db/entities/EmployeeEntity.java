package de.tekup.db.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	@Id
	private int id;
	@Column(length = 50)
	private String name;
	@Column(length = 70,nullable = false,unique = true)
	private String email;
	
	private LocalDate dob;
	
	

}
