package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.UserDetails;

public interface UserDetailsDao {
	List<UserDetails> getUserDetails();
	UserDetails findUserById(Integer userId);
}
