package com.petOcare.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petOcare.inventory.dto.AnimalForm;

@RestController
public class InventoryController {
	
	@GetMapping(value="/inventory")
	public List<String> getInventoryList(String inventoryName)
	{  List<String> dummy=new ArrayList<>();
	      dummy.add("adoptions");
	      dummy.add("Plants");
	      return dummy;
		
	}
	
	@PostMapping(value="/guardian/addAnimal")
	public ResponseEntity<T> addAnimalForAdoption(@RequestBody AnimalForm animalForm)
	{
		
	}

}
