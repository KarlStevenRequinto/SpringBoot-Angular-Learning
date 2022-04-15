package com.service.implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	public static List<User> usersList = new ArrayList<>();
	
	private static Long Counter = (long) 1;
	
	static {
		User user1 = new User(Counter++,"Kheeton Lucas","Requinto","Philippines","Kilo","Kilukas",4,0,"Male");
		usersList.add(user1);
		
		User user2 = new User(Counter++,"Karl Steven","Requinto","Philippines","Kokoy","Lerd Robott",30,0,"Male");
		usersList.add(user2);
		
		User user3 = new User(Counter++,"April Vivien","Hamantoc","Philippines","Bibian","BibianHamantoc",29,0,"Female");
		usersList.add(user3);
	}

	@Override
	public List<User> findAll() {
		return usersList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
	}

	@Override
	public Optional<User> findById(Long id) {
		return usersList.stream().filter(user -> user.getId() == id).findFirst();
		
	}

	@Override
	public void add(User user) {
		user.setId(Counter++);
		usersList.add(user);
		
	}
	
	@Override
	public Optional<User> delete(Long id) {
		Optional<User> userOpt = usersList.stream().filter(user -> user.getId() == id).findFirst();
		
		if(userOpt.isPresent()) {
			usersList =  usersList.stream().filter(user -> userOpt.get().getId() != user.getId()).collect(Collectors.toList());
			return userOpt;
		}
		
		return Optional.empty();
	}
	
	@Override
	public Optional<User> update(User user){
		Optional<User> userOpt = usersList.stream().filter(u -> u.getId() == user.getId()).findFirst();
		
		if(userOpt.isPresent()) {
			User existingUser = userOpt.get();
			
			if (user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}
			
			if (user.getLastName() != null) {
				existingUser.setLastName(user.getFirstName());
			}
			
			if (user.getAge() != null) {
				existingUser.setAge(user.getAge());
			}
			
			if (user.getProfileName() != null) {
				existingUser.setProfileName(user.getProfileName());
			}
			
			if (user.getCountry() != null) {
				existingUser.setCountry(user.getCountry());
			}
			
			
			if (user.getNumFriends() != null) {
				existingUser.setNumFriends(user.getNumFriends());
			}
			
			if (user.getGender() != null) {
				existingUser.setGender(user.getGender());
			}
			
			usersList = usersList.stream().filter(u -> u.getId() != existingUser.getId()).collect(Collectors.toList());
			usersList.add(existingUser);
			
			return Optional.of(existingUser);
			
		}
		return Optional.empty();
	}
	
}
