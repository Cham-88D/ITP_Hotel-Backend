package com.itp.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.itp.hotel.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String na);
	@Query(value = "SELECT * FROM roles r WHERE r.name = :name", 
			  nativeQuery = true)
			Role findRolebyNamee(@Param("name") String name);
}
