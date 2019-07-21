package com.petOcare.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petOcare.inventory.model.Pets;

@Repository
public interface PetRepository extends JpaRepository<Pets, Integer> {

}
