package com.projectexample.ecommercedemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projectexample.ecommercedemo.entity.SigninEntity;
import com.projectexample.ecommercedemo.repository.SigninRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SigninRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SigninEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }System.out.println("DB email: " + user.getEmail());
        System.out.println("DB encoded password: " + user.getPassword());
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
