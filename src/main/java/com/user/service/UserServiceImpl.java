package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserDto userDto) {
		User user = new User();
		user.setId(generateNewUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setAge(userDto.getAge());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setQualification(userDto.getQualification());
		user.setOccupation(userDto.getOccupation());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :" + id));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUserById(Long id, UserDto userDetails) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setGender(userDetails.getGender());
        user.setAge(userDetails.getAge());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setQualification(userDetails.getQualification());
        user.setOccupation(userDetails.getOccupation());

        return userRepository.save(user);
    }

	@Override
	public String deleteUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found :" + id));
		userRepository.delete(user);
		return "Users Deleted Successfully";
	}

	private Long generateNewUserId() {
		Long lastUserId = userRepository.findByMaxId().orElse(0L);
		return lastUserId + 1;
	}

}
