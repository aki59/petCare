package com.petOcare.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petOcare.security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailId(String email);


	User findByfirstName(String firstName);
}
