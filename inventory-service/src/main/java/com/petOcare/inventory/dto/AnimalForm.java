package com.petOcare.inventory.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnimalForm {
	
	private String animalName;
	private String animalType;
	private String animalBreed;
	private Integer animalAge;
	private String animalSex;
	private String animalBehavior;
	private String animalComplication;
	private String comments;
	//private Address guardianAddress;
	private Boolean isVaccinated;
	private Boolean isNeutered;
	private Date requestDate;
	

}
