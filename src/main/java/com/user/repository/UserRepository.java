package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT MAX(user.id) FROM User user")
	Optional<Long> findByMaxId();

}
