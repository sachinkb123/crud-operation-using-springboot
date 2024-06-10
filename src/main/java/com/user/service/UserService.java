package com.user.service;

import java.util.List;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;

public interface UserService {

	public User createUser(UserDto userDto);

	public User getUserById(Long id) throws UserNotFoundException;

	public List<User> getAllUsers();

	public User updateUserById(Long id, UserDto userDetails) throws UserNotFoundException;

	public String deleteUserById(Long id) throws UserNotFoundException;

}
