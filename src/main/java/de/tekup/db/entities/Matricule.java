package de.tekup.db.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Matricule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String code;
	
	private LocalDate expDate;
	@JsonIgnore
	@OneToOne(mappedBy = "matricule")
	private EmployeeEntity employee;
	@JsonIgnore
	@ManyToOne
	private Creator creator;

}
