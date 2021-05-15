package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itp.hotel.model.ResMenuItem;

import com.itp.hotel.exception.*;
import com.itp.hotel.repository.ResMenuItemRepository;
import com.itp.hotel.service.ResMenuItemService;

@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")

public class Res_Menu_Item_Controller {
	
	
	@Autowired
	private ResMenuItemRepository res_menu_item_repository;
	@Autowired
	private ResMenuItemService resMenuService;
	
	//get all menu items
	@GetMapping("/res_menu_item")
	public List<ResMenuItem> getRes_Menu_items(){
		return resMenuService.listAll();
	}
	
	//get all menu items
		@GetMapping("/menu/{id}")
		public ResponseEntity getMenuItemById(@PathVariable Long id){
			return ResponseEntity.ok(resMenuService.getById(id));
		}
		
	/*
	@GetMapping("/res_menu_item/{menuItemType}")
	public List<Res_Menu_item> getRes_Menu_items_by_type(@PathVariable String menuItemType){
		return res_menu_item_repository.findBymenuItemType(menuItemType);
	
	
	}*/
	
	
	@GetMapping("/res_menu_item/type/{menuItemType}")
	public List<ResMenuItem> getRes_Menu_items_by_type(@PathVariable String menuItemType){
		return res_menu_item_repository.searchQuery(menuItemType);
	}
	
	@GetMapping("/res_menu_item/name/{menuItemName}")
	public List<ResMenuItem> getRes_Menu_items_by_name(@PathVariable String menuItemName){
		return res_menu_item_repository.searchMenuName(menuItemName);
	}
	
	//insert
	@PostMapping("/res_menu_item")
	public ResMenuItem insertRes_Menu_item(@RequestBody   ResMenuItem res_Menu_item){
		return res_menu_item_repository.save(res_Menu_item);
	}
	
	
		
		
	
	
	
	//update
	@PutMapping("/res_menu_item/{id}")
	public ResponseEntity<ResMenuItem> updateMenuItems(@PathVariable Long id,@RequestBody ResMenuItem menu_item_detail){
		
		ResMenuItem menu_item = res_menu_item_repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
		
		//menu_item.setMenuItemType(menu_item_detail.getMenuItemType());
		menu_item.setMenuItemName(menu_item_detail.getMenuItemName());
		menu_item.setUnitPrice(menu_item_detail.getUnitPrice());
		menu_item.setDescription(menu_item_detail.getDescription());
		menu_item.setDiscount(menu_item_detail.getDiscount());
		//menu_item.setAvailableStatus(menu_item_detail.getAvailableStatus());
		
		
		ResMenuItem updateMenu_item=	res_menu_item_repository.save(menu_item);
	return ResponseEntity.ok(updateMenu_item);
		
	}
	
	//get menu item by menu type
	/*
	@RequestMapping(value = "/res_menu_item/{id}")
	public List<Res_Menu_item> getOrderDetailsByItemType(@PathVariable String id){
		return menu_item_service.getOrderDetailsByItemType(id);
	}*/
     
	
	
	
	
	
	//insert menu items
	//**********************
	/*@PostMapping("/res_menu_item")
	public Res_Menu_item insertRes_Menu_item(@RequestBody   Res_Menu_item res_Menu_item){
		return res_Menu_Item_Repository.save(res_Menu_item);
	}*/

	
	//get food item id
	@GetMapping("/res_menu_item/{id}")
	public ResponseEntity<ResMenuItem> getMenu_item_by_id(@PathVariable Long id) {
			
		ResMenuItem menu_item = res_menu_item_repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
		return ResponseEntity.ok(menu_item);
		
		
		
	}
	
	//update menu item details
	/*@PutMapping("/res_menu_item/{id}")
	public ResponseEntity<Res_Menu_item> updateMenuItems(@PathVariable Long id,@RequestBody Res_Menu_item menu_item_detail){
		
		Res_Menu_item menu_item = res_Menu_Item_Repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
		
		//menu_item.setMenuItemType(menu_item_detail.getMenuItemType());
		menu_item.setMenuItemName(menu_item_detail.getMenuItemName());
		menu_item.setUnitPrice(menu_item_detail.getUnitPrice());
		menu_item.setDescription(menu_item_detail.getDescription());
		menu_item.setDiscount(menu_item_detail.getDiscount());
		menu_item.setAvailableStatus(menu_item_detail.getAvailableStatus());
		
		
	Res_Menu_item updateMenu_item=	res_Menu_Item_Repository.save(menu_item);
	return ResponseEntity.ok(updateMenu_item);
		
	}*/
	
	
	//delete menu items details
	@DeleteMapping("/res_menu_item/{id}")
	public ResponseEntity< Map<String, Boolean>> deleteMenuItems(@PathVariable Long id){
		
		ResMenuItem menu_item = res_menu_item_repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
		
		res_menu_item_repository.delete(menu_item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	
	
}
