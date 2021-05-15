package com.itp.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.ResMenuItem;
import com.itp.hotel.repository.ResMenuItemRepository;

@Service
public class ResMenuItemService {
	
	@Autowired
	private ResMenuItemRepository repo;
	
	public List<ResMenuItem> listAll(){
		List<ResMenuItem> items = repo.findAll();
		List<ResMenuItem> formattedItems = new ArrayList<ResMenuItem>();
		for(ResMenuItem b :items ) {
			ResMenuItem newBevObj = new ResMenuItem();
			newBevObj.setMenu_item_id(b.getMenu_item_id());
			newBevObj.setMenuItemType(b.getMenuItemType());
			newBevObj.setMenuItemName(b.getMenuItemName());
			newBevObj.setDescription(b.getDescription());
			newBevObj.setDiscount(b.getDiscount());
			newBevObj.setUnitPrice(b.getUnitPrice());
			
			formattedItems.add(newBevObj);
		}
		return formattedItems;
	}
	
	public ResMenuItem getById(Long id){
		ResMenuItem item = repo.findById(id).get();;
		
			ResMenuItem newBevObj = new ResMenuItem();
			newBevObj.setMenu_item_id(item.getMenu_item_id());
			newBevObj.setMenuItemType(item.getMenuItemType());
			newBevObj.setMenuItemName(item.getMenuItemName());
			newBevObj.setDescription(item.getDescription());
			newBevObj.setDiscount(item.getDiscount());
			newBevObj.setUnitPrice(item.getUnitPrice());
			
		
		return newBevObj;
	}
	
}
