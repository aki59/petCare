package com.petOcare.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petOcare.inventory.dto.AnimalForm;
import com.petOcare.inventory.model.Pets;
import com.petOcare.inventory.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetRepository petRepository;

	@Override
	public Pets addAPet(AnimalForm animalForm) {
     
		
		return null;
	}

}
