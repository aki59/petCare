package com.petOcare.inventory.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.petOcare.inventory.dto.AnimalForm;
import com.petOcare.inventory.model.PetType;
import com.petOcare.inventory.model.Pets;
import com.petOcare.inventory.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	PetRepository petRepository;
	
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private PetServiceImpl( KafkaTemplate<String,String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public Pets addAPet(AnimalForm animalForm) {
		Pets pet=new Pets();
		try {
			BeanUtils.copyProperties(pet,animalForm);
			pet.setAnimalType(new PetType(animalForm.getPetType()));
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
    
		Pets result= petRepository.save(pet) ;
		//fireAddedAPetEvent(pet);
		return result;
	}

	private void fireAddedAPetEvent(AnimalForm pet) {
		kafkaTemplate.send("pets",pet.getAnimalName()+" created");
		
	}

}
