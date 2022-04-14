package com.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

// THIS WILL TELL SPRING THAT UNDER THIS CLASS THERE IS A BUSINESS LOGIC
@Service
public class UserServiceImplementation implements UserService{

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> usersList = new ArrayList<>();
		return usersList;
	}

}
