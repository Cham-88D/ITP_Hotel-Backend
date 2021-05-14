package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE id=?1")
	public User getUserById(Long id);
	
	@Query("SELECT u FROM User u WHERE username=?1")
	public User getUserByUsername(String username);
}
