package com.petOcare.inventory.service;

import com.petOcare.inventory.dto.AnimalForm;
import com.petOcare.inventory.model.Pets;

public interface PetService {

	Pets addAPet(AnimalForm animalForm);

}
