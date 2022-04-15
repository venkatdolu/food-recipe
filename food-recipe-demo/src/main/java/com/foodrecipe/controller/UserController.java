package com.foodrecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.foodrecipe.entity.User;
import com.foodrecipe.service.IUserDetailService;

@RestController
public class UserController {

	@Autowired
	private IUserDetailService userDetailService;

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getuserByName(@PathVariable("id") String name) {
		User user = userDetailService.getUserByName(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userDetailService.addUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<User> updateRecipeDetails(@RequestBody User user) {
		userDetailService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}