package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Item;
import com.app.repository.ItemRepository;
import com.app.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item updateItem(int itemid, Item item) {
		Item updatedItem = itemRepository.findById(itemid).get();
		updatedItem.setMedicineName(item.getMedicineName());
		updatedItem.setMedicineBrand(item.getMedicineBrand());
		updatedItem.setMedicineQuantity(item.getMedicineQuantity());
		updatedItem.setPrice(item.getPrice());
		updatedItem.setPicByte(item.getPicByte());
		return itemRepository.save(updatedItem);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();		
	}

	@Override
	public void deleteItem(int id) {
		itemRepository.deleteById(id);
	}

	@Override
	public List<Item> filterItem(String medicineName, String medicineBrand) {
		if(!medicineName.equals("") && !medicineBrand.equals(""))
			return itemRepository.findByMedicineNameAndMedicineBrand(medicineName, medicineBrand);
		else if(!medicineName.equals("") && medicineBrand.equals(""))
			return itemRepository.findByMedicineName(medicineName);
		else if(medicineName.equals("") && !medicineBrand.equals(""))
			return itemRepository.findByMedicineBrand(medicineBrand);
		else
			return itemRepository.findAll();
	}
	
}
