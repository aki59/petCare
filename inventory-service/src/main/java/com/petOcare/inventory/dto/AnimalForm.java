package com.petOcare.inventory.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class AnimalForm {
	
	private String animalName;
	private Integer petType;
	private String animalBreed;
	private LocalDate birthDate;
	private String animalSex;
	private String animalBehavior;
	private String animalComplication;
	private String comments;
	//private Address guardianAddress;
	private Boolean isVaccinated;
	private Boolean isNeutered;
	private Date requestDate;
	

}
