package com.petOcare.security.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petOcare.security.model.User;
import com.petOcare.security.util.Status;

@RestController
@Transactional
public class UserController {
	private final Logger LOGGER= LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;

	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Status> createUser(@Valid final UserDto userDto)
	{ LOGGER.info("Registering User Account for user"+ userDto.getFirstName());

	  final User registered= userService.registerNewUserAccount(userDto);
		return new ResponseEntity<>(new Status("created"+registered.getFirstName()),HttpStatus.CREATED);
		
	}

}
