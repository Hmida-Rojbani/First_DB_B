package de.tekup.db.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(length = 70,nullable = false,unique = true)
	private String email;
	
	private LocalDate dob;
	//to control Date Format
	//public void setDob(String date) {
	//	DateTimeFormatter pattern= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//	this.dob = LocalDate.parse(date, pattern);
	//}
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="matricule")
	private Matricule matricule; 
	
	@ManyToMany(mappedBy = "employees")
	private List<Project> projects;
	

}
