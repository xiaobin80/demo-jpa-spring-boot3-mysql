package com.example.demo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Repository
public class UserDetailsImpl implements UserDetailsDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getUserDetails() {
		// TODO Auto-generated method stub
		String jpql = "SELECT user FROM UserDetails as user ORDER BY user.userId DESC";
		List<UserDetails> result = entityManager.createQuery(jpql).getResultList();
		for (UserDetails userDetails : result) {
			logger.info(userDetails.getName());
		}
		return (List<UserDetails>)result;
	}

	@Override
	public UserDetails findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return entityManager.find(UserDetails.class, userId);
	}

}
