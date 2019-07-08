package com.petOcare.security.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petOcare.security.dto.User;
import com.petOcare.security.util.Status;

@RestController
@Transactional
public class UserController {
	

 BCryptPasswordEncoder passEncoder=new BCryptPasswordEncoder();
 
 @PersistenceContext
 EntityManager em;


	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public ResponseEntity<Status> createUser(@RequestBody User user)
	{
		User localUser=new User();
		localUser.setAge(user.getAge());
		localUser.setEmailId(user.getEmailId());
		localUser.setPassword(passEncoder.encode(user.getPassword()));
		localUser.setFirstName(user.getFirstName());
		em.persist(localUser);
		return new ResponseEntity<Status>(new Status("created"),HttpStatus.CREATED);
		
	}

}
