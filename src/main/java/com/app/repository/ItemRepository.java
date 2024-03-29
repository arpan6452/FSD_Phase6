package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	public List<Item> findByMedicineNameAndMedicineBrand(String medicineName, String medicineBrand);//(String itemCatagory, String itemCourse);
	public List<Item> findByMedicineName(String medicineName);
	public List<Item> findByMedicineBrand(String medicineBrand);
}
