package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Item;
import com.app.service.MedicineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@CrossOrigin(origins= {"*"})
@Api(value = "Medicine Controller", description = "This is a Medicine Controller API, you can get, create, update and delete medicine.")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@ApiOperation("You can create a new medicine. Only admin can access this api end point.")
	@PostMapping("/item")
	public Item uplaodImage(@RequestParam("picByte") MultipartFile[] image, @RequestParam("medicineName") String medicineName,
			@RequestParam("medicineBrand") String medicineBrand, @RequestParam("medicineQuantity") int medicineQuantity, 
			@RequestParam("price") long price) throws IOException {
		Item item = new Item();
		item.setMedicineBrand(medicineBrand);
		item.setMedicineName(medicineName);
		item.setMedicineQuantity(medicineQuantity);
		item.setPrice(price);
		item.setPicByte(image[0].getBytes());
		return medicineService.createItem(item);
	}
	
	/*
	 * @ApiOperation("You can create a new medicine. Only admin can access this api end point."
	 * )
	 * 
	 * @PostMapping("/item") public Item createItem(@RequestBody Item item) { return
	 * medicineService.createItem(item); }
	 */
	
	@ApiOperation("You can update a medicine, based on the medicine id you provide. Only admin can access this api end point.")
	@PutMapping("/item/{id}")
	public Item updateItem(@PathVariable int id, @RequestParam("picByte") MultipartFile[] image, @RequestParam("medicineName") String medicineName,
			@RequestParam("medicineBrand") String medicineBrand, @RequestParam("medicineQuantity") int medicineQuantity, 
			@RequestParam("price") long price) throws IOException {
		Item item = new Item();
		item.setMedicineBrand(medicineBrand);
		item.setMedicineName(medicineName);
		item.setMedicineQuantity(medicineQuantity);
		item.setPrice(price);
		item.setPicByte(image[0].getBytes());
		return medicineService.updateItem(id, item);
	}


	/*
	 * @ApiOperation("You can update a medicine, based on the medicine id you provide. Only admin can access this api end point."
	 * )
	 * 
	 * @PutMapping("/item/{id}")
	 * // @PreAuthorize("hasRole('admin')")//hasRole(T(com.app.entity.RoleName).
	 * ROLE_ADMIN)") public Item updateItem(@PathVariable int id, @RequestBody Item
	 * item) { return medicineService.updateItem(id, item); }
	 */

	@ApiOperation("Find the list of all medicines.")
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return medicineService.getAllItems();
	}

	@ApiOperation("Find the list of all medicines based on the name and brand you provide.")
	@GetMapping("/items/filter")
	public List<Item> filterItem(@RequestParam String medicineName, @RequestParam String medicineBrand) {
		return medicineService.filterItem(medicineName, medicineBrand);
	}

	@ApiOperation("Delete a medicine. Only admin can access this api end point.")
	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable int id) {
		medicineService.deleteItem(id);
	}

}
