package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itp.hotel.model.FoodDetails;

public interface FoodDetailsRepository extends JpaRepository<FoodDetails, Integer> {

	@Query(value = "select * from food_details where food_name = ?1", nativeQuery = true)
	FoodDetails findByName(String name);

	

}
