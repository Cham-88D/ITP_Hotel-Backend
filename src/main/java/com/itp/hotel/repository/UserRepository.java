package com.itp.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	@Query(value = "SELECT * FROM users s WHERE s.role_id = :id", 
			  nativeQuery = true)
	  Optional<User> userExistsByRole(@Param("id") int id);
    
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
