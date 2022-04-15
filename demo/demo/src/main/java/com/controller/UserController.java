package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?>findAll(){
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<User> userOpt = userService.findById(id);
		
		if(userOpt.isPresent()) {
			return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody User user) {
		userService.add(user);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		Optional<User> optUser = userService.delete(id);
		
		
		if(optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user) {
		Optional<User> optUser = userService.update(user);
		
		if (optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(), HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
