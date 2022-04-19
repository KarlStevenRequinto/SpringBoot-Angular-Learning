package com.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImplementation implements UserService{
	
//	public static List<User> usersList = new ArrayList<>();
//	
//	private static Long Counter = (long) 1;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Optional<User> findById(Long id) {
//		return usersList.stream().filter(user -> user.getId() == id).findFirst();
		return userRepository.findById(id);
	}

	@Override
	public void add(User user) {
//		user.setId(Counter++);
//		usersList.add(user);
		user.setPassWord(passwordEncoder.encode(user.getPassWord()));
		userRepository.save(user); 
		
	}
	
	@Override
	public Optional<User> delete(Long id) {
		Optional<User> userOpt = userRepository.findById(id);
//		Optional<User> userOpt = usersList.stream().filter(user -> user.getId() == id).findFirst();
		
		if(userOpt.isPresent()) {
			userRepository.delete(userOpt.get());
//			usersList =  usersList.stream().filter(user -> userOpt.get().getId() != user.getId()).collect(Collectors.toList());
			return userOpt;
		}
		
		return Optional.empty();
	}
	
	@Override
	public Optional<User> update(User user){
//		Optional<User> userOpt = usersList.stream().filter(u -> u.getId() == user.getId()).findFirst();
		Optional<User> userOpt = userRepository.findById(user.getId());
		
		if(userOpt.isPresent()) {
			User existingUser = userOpt.get();
			
			if (user.getUserName() != null) {
				existingUser.setUserName(user.getUserName());
			}
			
			if (user.getUserName() != null) {
				existingUser.setPassWord(passwordEncoder.encode(user.getPassWord()));
			}
			
			if (user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}
			
			if (user.getLastName() != null) {
				existingUser.setLastName(user.getLastName());
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
			
			if (user.getGender() != null) {
				existingUser.setGender(user.getGender());
			}
			
//			usersList = usersList.stream().filter(u -> u.getId() != existingUser.getId()).collect(Collectors.toList());
		
			userRepository.save(existingUser);
			
			return Optional.of(existingUser);
		}
		return Optional.empty();
	}
	
	@Override
	public List<User> findByCriteria(String criteria, String searchItem) {
		switch (criteria) {
		case "userName":
			return this.userRepository.findByUserName(searchItem);
		case "firstName":
			return this.userRepository.findByFirstName(searchItem);
		case "lastName":
			return this.userRepository.findByLastName(searchItem);
		case "profileName":
			return this.userRepository.findByProfileName(searchItem);
		case "age":
			try {
				Integer age = Integer.valueOf(searchItem); 
				return this.userRepository.findByAge(age);
			} catch (NumberFormatException e) {
				System.out.println("Could not convert age to number...");
			}
			
			return new ArrayList<>();
		case "country":
			return this.userRepository.findByCountry(searchItem);
		}
		return new ArrayList<>();
	}
	
}
