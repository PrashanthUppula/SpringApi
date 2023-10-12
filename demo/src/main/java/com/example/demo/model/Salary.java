package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Salary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long employeeId;
	
	@Column(name = "salaryAmount")
	private long salaryAmount;
	
}
