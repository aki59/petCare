package com.petOcare.security.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.petOcare.security.AuthServiceApplication;
import com.petOcare.security.controller.UserController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AuthServiceApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
public class AuthServiceApplicationTest {
	
	@Autowired
	UserController controller;

    @Test
    public void contextLoads() throws Exception {
    	assertThat(controller).isNotNull();
    }
}
