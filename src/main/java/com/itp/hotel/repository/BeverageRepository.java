package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.Beverage;
@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {
	
	
	@Query(value = "SELECT * FROM beverages WHERE b_type =?1",nativeQuery = true)
	public List<Beverage> searchQuery(String bevType);


}