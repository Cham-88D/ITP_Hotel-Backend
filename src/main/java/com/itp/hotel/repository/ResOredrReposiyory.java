package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.ResOrder;

@Repository
public interface ResOredrReposiyory extends JpaRepository<ResOrder, Long>{
		
	
}
