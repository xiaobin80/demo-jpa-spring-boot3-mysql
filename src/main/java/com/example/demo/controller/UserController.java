package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserDetailsService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3030", "http://localhost:4200"})
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDetails>> getAllUser() {
		List<UserDetails> user = userService.getUsers();
		return new ResponseEntity<List<UserDetails>>(user, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3030", "http://localhost:4200"})
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getUser(@PathVariable(value = "userId") Integer userId) {
		UserDetails user = userService.findUser(userId);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<UserDetails> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		for(UserDetails user : users) {
			System.out.println(user.getEmail() + " " + user.getName());
		}
		
		redisCliTest();
		
		redisTest();
		
		return "userList";
	}
	
	/**
	 * for redis-cli
	 */
	public void redisCliTest() {
        String cliVal = stringRedisTemplate.opsForValue().get("mykey2");
        System.out.println("redis-cli value: " + cliVal);
	}
	
	/**
	 * for redis
	 */
	public void redisTest() {
		//redisTemplate.opsForValue().set("mykey3", "spring boot insert message.");
        String rtnValue = (String)redisTemplate.opsForValue().get("mykey3");
        System.out.println("redis value: " + rtnValue);
	}
}
