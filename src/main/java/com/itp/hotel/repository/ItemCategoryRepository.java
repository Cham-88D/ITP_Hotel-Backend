package com.itp.hotel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.MenuItemCategory;


public interface ItemCategoryRepository extends JpaRepository<MenuItemCategory, Long> {
	
}
