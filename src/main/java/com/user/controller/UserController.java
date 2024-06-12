package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
		User createdUser = userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
		User getUserById = userService.getUserById(id);
		return new ResponseEntity<>(getUserById, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/updateUserDetails/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDetails)
			throws UserNotFoundException {
		User updateUser = userService.updateUserById(id, userDetails);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> DeleteUserById(@PathVariable Long id) throws Exception {
		String deleteUserById = userService.deleteUserById(id);
		return new ResponseEntity<>(deleteUserById, HttpStatus.OK);
	}

}
