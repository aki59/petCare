package com.petOcare.security.test;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.service.UserService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petOcare.security.AuthServiceApplication;
import com.petOcare.security.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AuthServiceApplication.class)
@ActiveProfiles("test")
public class UserControllerTest {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@InjectMocks
	private UserController accountController;


	private MockMvc mockMvc;

	private static final String CLIENT_ID = "inventory-service";
	//private String accessToken;
	
	@SpyBean
	private UserService userService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void shouldGive200_status() throws Exception {
		String accessToken = obtainAccessToken();
		mockMvc.perform(get("/user/current").header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk());
	}
	

	
	@Test
	public void shouldCreateUser() throws Exception {
		String accessToken = obtainAccessToken();
		final UserDto user=new UserDto();
		user.setAge(20);
		user.setFirstName("prakash");
		user.setPassword("password1");
		user.setLastName("tiwari");
		user.setRoles("Role_Volunteer");
		user.setEmail("akash21tiwari@gmail.com");
		
		String json =mapper.writeValueAsString(user);
		
		mockMvc.perform(post("/user/createUser").header("Authorization", "Bearer " + accessToken).contentType(MediaType.APPLICATION_JSON).content(json))
		                                   .andExpect(status().isOk());
	
	}
	private String obtainAccessToken() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "client_credentials");
		params.add("scope", "server");

		ResultActions result = mockMvc.perform(post("/oauth/token")
				                      .param("grant_type", "client_credentials")
		                              .with(httpBasic(CLIENT_ID, "inventory001"))
		                              .accept("application/json;charset=UTF-8"))
				                      .andExpect(status().isOk());

		String resultString = result.andReturn().getResponse().getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();
	}

}
