package com.petOcare.security.service;

import com.petOcare.security.dto.UserDto;
import com.petOcare.security.model.User;
import com.petOcare.security.repository.RoleRepository;
import com.petOcare.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User registerNewUserAccount(final UserDto userDto) {
        Optional<User> existing= userRepository.findByEmailId(userDto.getEmail());
        existing.ifPresent(it->{throw new IllegalArgumentException("user already exist with mail ID :-" +it.getEmailId());});


        final User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmailId(userDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByroleName(userDto.getRoles())));
        return userRepository.save(user);

    }

}
