package com.app.api;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.entity.Item;
import com.app.repository.ItemRepository;
import com.app.service.MedicineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineApplicationTests {

	@Autowired
	MedicineService service;
	
	@MockBean
	ItemRepository repository;
	
	String path = System.getProperty("user.dir") + "\\images\\bike.jpg";

	@Test
	public void testgetMedicine() throws IOException {
		Item item1 = new Item();
		item1.setItemid(1);
		item1.setMedicineBrand("Medicine Brand");
		item1.setMedicineName("Medicine Name");
		item1.setMedicineQuantity(10);
		item1.setPrice(100);		
		FileInputStream inputFile1 = new FileInputStream(path);  
		MockMultipartFile image1 = new MockMultipartFile("file", "bike.jpg", "multipart/form-data", inputFile1); 
		item1.setPicByte(image1.getBytes());
		
		Item item2 = new Item();
		item2.setItemid(2);
		item2.setMedicineBrand("Medicine Brand");
		item2.setMedicineName("Medicine Name");
		item2.setMedicineQuantity(10);
		item2.setPrice(100);
		FileInputStream inputFile2 = new FileInputStream( path);  
		MockMultipartFile image2 = new MockMultipartFile("file", "bike.jpg", "multipart/form-data", inputFile2); 		
		item2.setPicByte(image2.getBytes());
		
		when(repository.findAll()).thenReturn(Stream.of(item1, item2).collect(Collectors.toList()));
		assertEquals(2, service.getAllItems().size());
	}

	@Test
	public void testcreateMedicine() throws IOException {
		Item item = new Item();
		item.setItemid(1);
		item.setMedicineBrand("Medicine Brand");
		item.setMedicineName("Medicine Name");
		item.setMedicineQuantity(10);
		item.setPrice(100);
		FileInputStream inputFile = new FileInputStream(path);  
		MockMultipartFile image = new MockMultipartFile("file", "bike.jpg", "multipart/form-data", inputFile); 		
		item.setPicByte(image.getBytes());	
		
		when(repository.save(item)).thenReturn(item);
		assertEquals(item, service.createItem(item));
	}

	@Test
	public void testdeleteMedicine() {
		service.deleteItem(1);
		verify(repository, times(1)).deleteById(1);
	}

}
