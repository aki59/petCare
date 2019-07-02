package com.petOcare.inventory.dto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import com.petOcare.inventory.dto.AnimalForm;

public class AnimalFormUnitTest {
	
	@Test
	public void givenBuider_AnimalFormIsBuilt()
	{
		AnimalForm testForm = AnimalForm.builder()
				                    .animalName("lucy")
				                    .animalBreed("Indie")
				                    .animalSex("F")
				                    .build();
		
		assertThat(testForm.getAnimalName()).isEqualTo("lucy");
	}

}
