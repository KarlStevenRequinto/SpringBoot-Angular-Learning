package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;


// ENTRY POINT OF CLIENT TO OUR APPLICATION
@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	};
}
