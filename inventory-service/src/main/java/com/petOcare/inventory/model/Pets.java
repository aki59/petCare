package com.petOcare.inventory.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import com.petOcare.inventory.dto.AnimalForm;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Pets {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String animalName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "animalType_id")
	private PetType animalType;
	private String animalBreed;
	private Integer animalAge;
	private String animalSex;
	private String animalBehavior;
	private String animalComplication;
	@Column(length=100)
	private String comments;
	private Boolean isVaccinated;
	private Boolean isNeutered;
	private Date requestDate;
	private String userName;
	private String status;
	
	

}
