package com.petOcare.inventory.test;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.petOcare.inventory.InventoryApplication;
import com.petOcare.inventory.model.PetType;
import com.petOcare.inventory.model.Pets;
import com.petOcare.inventory.repository.PetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InventoryApplication.class)
public class PetServiceTest {
	
	@Autowired
	PetRepository testPetRepository;
	
	private KafkaTemplate<String,Pets> kafkaTemplate;
	
	
	@Test
	public void shouldAddAPet() throws Exception{
		//String accessToken = obtainAccessToken();
		Pets testPet = Pets.builder()
				           .animalName("testGabbar")
				           .animalAge(8)
				           .animalBreed("Bourbel")
				           .animalSex("M")
				           .animalType(new PetType(1))
				           .birthDate(LocalDate.parse("2019-08-01"))
				           .build();
		
		kafkaTemplate.send("pets",testPet.getId()+" created",testPet);
		
		//testPetRepository.save(testPet);
	}

}
