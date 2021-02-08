package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.User;
import com.exmaple.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);
	User save(UserRegistrationDto registrationDto);
}
