package com.petOcare.security.controller;


import javax.validation.Valid;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petOcare.security.model.User;
import com.petOcare.security.util.Status;

@RestController
public class UserController {
	private final Logger LOGGER= LoggerFactory.getLogger(getClass());
	public static final String ROLE_USER = "ROLE_USER";

	@Autowired
	UserService userService;
	
	@GetMapping("user/sayHello")
	public String hello() {
		return "hello";
	}

	//@Secured({ROLE_USER})
	//@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(value="user/createUser",method=RequestMethod.POST)
	@ResponseBody
	public Status createUser(@Valid @RequestBody UserDto userDto)
	{ LOGGER.info("Registering User Account for user "+ userDto.getFirstName());

	  final User registered= userService.registerNewUserAccount(userDto);
		return new Status("created "+registered.getFirstName());
		
	}

}
