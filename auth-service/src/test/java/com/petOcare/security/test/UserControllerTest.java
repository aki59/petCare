package com.petOcare.security.test;

import com.petOcare.security.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petOcare.security.controller.UserController;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@InjectMocks
	UserController accountController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(accountController).build();	
	}
	
	@Test
	public void shouldCreateUser() throws Exception {
		final UserDto user=new UserDto();
		user.setAge(20);
		user.setFirstName("akash");
		user.setPassword("password");
		user.setEmail("akash69tiwari@gmail.com");
		
		String json =mapper.writeValueAsString(user);
		
		mockMvc.perform(post("/createUser").contentType(MediaType.APPLICATION_JSON).content(json))
		                                   .andExpect(status().isOk());
	
	}

}
