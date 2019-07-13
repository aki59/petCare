package com.petOcare.security.model.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petOcare.security.model.Role;
import com.petOcare.security.model.User;
import com.petOcare.security.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    public CustomUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        try {
            final Optional<User> existing = userRepository.findByEmailId(email);
            if(existing.isPresent()) {
                User user= existing.get();
                return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),true, true, true, true, getAuthorities(user.getRoles()));
            }
            else {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    // UTIL

    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final Role role : roles) {
        	authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }


}
