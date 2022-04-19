package com.component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersInDb implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User("Kheeton Lucas","Requinto","Philippines","Kilo",UUID.randomUUID().toString(),"Kilukas",4,"Male");
		userRepository.save(user1);
		User user2 = new User("Karl Steven","Requinto","Philippines","Kokoy",UUID.randomUUID().toString(),"Lerd Robott",30,"Male");
		userRepository.save(user2);
		User user3 = new User("April Vivien","Hamantoc","Philippines","Bibian",UUID.randomUUID().toString(),"BibianHamantoc",29,"Female");
		userRepository.save(user3);
		
		
		List<User> usersList = Arrays.asList(user1,user2,user3);
		
		usersList = usersList.stream().map(user -> {
			user.setPassWord(passwordEncoder.encode(user.getPassWord()));
			return user;
		}).collect(Collectors.toList());
		
		userRepository.saveAll(usersList);
	}

}
