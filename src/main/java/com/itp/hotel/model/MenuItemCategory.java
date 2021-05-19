package com.itp.hotel.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_item_category")
public class MenuItemCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id;
	
	
	@Column(name = "menu_item_type")
	private String menuItemType;

	public MenuItemCategory() {
		super();
	}

	public MenuItemCategory(String menuItemType) {
		super();
		this.menuItemType = menuItemType;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMenuItemType(String menuItemType) {
		this.menuItemType = menuItemType;
	}

	public long getId() {
		return id;
	}

	public String getMenuItemType() {
		return menuItemType;
	}
	
	
}