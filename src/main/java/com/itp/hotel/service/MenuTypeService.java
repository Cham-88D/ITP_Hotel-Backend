package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.DiscountPolicy;
import com.itp.hotel.model.MenuItemCategory;
import com.itp.hotel.repository.ItemCategoryRepository;

@Service
public class MenuTypeService {

	@Autowired
	private ItemCategoryRepository repo;
	
	public void save(MenuItemCategory m) {
		repo.save(m);
	}
	
	public List<MenuItemCategory> listAll(){
		return repo.findAll();
	}
}
