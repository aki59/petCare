package com.petOcare.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petOcare.security.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailId(String email);
	User findByfirstName(String firstName);
	List<User> findByFirstNameLength(@Param("length")Long length);
}
