package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserDetails;

public interface UserDetailsService {
	List<UserDetails> getUsers();
	UserDetails findUser(Integer userId);
}
