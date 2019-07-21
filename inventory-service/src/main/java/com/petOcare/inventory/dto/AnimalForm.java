package com.petOcare.inventory.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class AnimalForm {
	
	private String animalName;
	private String animalType;
	private String animalBreed;
	private Date birthDate;
	private String animalSex;
	private String animalBehavior="none";
	private String animalComplication="none";
	private String comments;
	//private Address guardianAddress;
	private Boolean isVaccinated;
	private Boolean isNeutered;
	private Date requestDate;
	

}
