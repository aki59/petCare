package com.petOcare.security.controller;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petOcare.security.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@InjectMocks
	UserController accountController;
	
	@SpyBean
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void shouldCreateUser() throws Exception {
		final UserDto user=new UserDto();
		user.setAge(20);
		user.setFirstName("akash");
		user.setPassword("password");
		user.setLastName("tiwari");
		user.setRoles("Role_Volunteer");
		user.setEmail("akash66tiwari@gmail.com");
		
		String json =mapper.writeValueAsString(user);
		
		mockMvc.perform(post("/createUser").contentType(MediaType.APPLICATION_JSON).content(json))
		                                   .andExpect(status().isOk());
	
	}

}
