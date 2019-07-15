package com.petOcare.security.service;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.model.User;
import com.petOcare.security.repository.RoleRepository;
import com.petOcare.security.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
	private final Logger LOGGER=LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User registerNewUserAccount(final UserDto userDto) {
        LOGGER.info("hi");
        Optional<User> existing= userRepository.findByEmailId(userDto.getEmail());
        existing.ifPresent(it->{throw new IllegalArgumentException("user already exist with mail ID :-" +it.getEmailId());});

        final User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmailId(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setRoles(Arrays.asList(roleRepository.findByroleName(userDto.getRoles())));
        return userRepository.save(user);

    }

}
