package com.itp.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itp.hotel.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "SELECT e.role_id FROM employee e WHERE e.role_id = :id", 
			  nativeQuery = true)
	  Optional<Integer> existsByRole(@Param("id") int id);
}
