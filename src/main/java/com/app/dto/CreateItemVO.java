package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

public class CreateItemVO {
	private String medicineName;
	private String medicineBrand;
	private int medicineQuantity;
	private double price;	
	private MultipartFile picByte;
	
	public CreateItemVO(String medicineName, String medicineBrand, int medicineQuantity, double price,
			MultipartFile picByte) {
		super();
		
		this.medicineName = medicineName;
		this.medicineBrand = medicineBrand;
		this.medicineQuantity = medicineQuantity;
		this.price = price;
		this.picByte = picByte;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineBrand() {
		return medicineBrand;
	}

	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}

	public int getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MultipartFile getPicByte() {
		return picByte;
	}

	public void setPicByte(MultipartFile picByte) {
		this.picByte = picByte;
	}
	
}
