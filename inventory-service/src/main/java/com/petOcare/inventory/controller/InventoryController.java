package com.petOcare.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petOcare.inventory.dto.AnimalForm;
import com.petOcare.inventory.model.Pets;
import com.petOcare.inventory.service.PetService;
import com.petOcare.inventory.util.Status;



@RestController
public class InventoryController {
	
	@Autowired
	PetService petService;
	


	
	@GetMapping(value="/say")
	public List<String> getInventoryList(String inventoryName)
	{  List<String> dummy=new ArrayList<>();
	      dummy.add("adoptions");
	      dummy.add("Plants");
	      return dummy;
		
	}
	
	@PostMapping(value="/addAnimal")
	public Status addPetForAdoption(@RequestBody AnimalForm pet)
	{   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final Pets petAdded=petService.addAPet(pet);
		return new Status("added animal"+pet.getAnimalName()+" for User "+principal.toString());
	}

}
