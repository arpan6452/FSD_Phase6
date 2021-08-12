package com.app.service;

import java.util.List;

import com.app.entity.Item;

public interface MedicineService {
	public Item createItem(Item item);
	public Item updateItem(int itemid, Item item);	
	public List<Item> getAllItems();
	public List<Item> filterItem(String medicineName, String medicineBrand);	
	public void deleteItem(int id);
}
