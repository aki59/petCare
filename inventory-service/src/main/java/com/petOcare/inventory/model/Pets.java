package com.petOcare.inventory.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Pets {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String animalName;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

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
	private Integer userID;
	private String status;

}
