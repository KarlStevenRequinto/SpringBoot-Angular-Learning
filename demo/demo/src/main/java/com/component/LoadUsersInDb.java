package com.component;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersInDb implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		
		User user = new User("Kheeton Lucas","Requinto","Philippines","Kilo","Kilukas",4,"Male");
		userRepository.save(user);
		user = new User("Karl Steven","Requinto","Philippines","Kokoy","Lerd Robott",30,"Male");
		userRepository.save(user);
		user = new User("April Vivien","Hamantoc","Philippines","Bibian","BibianHamantoc",29,"Female");
		userRepository.save(user);
	}

}
