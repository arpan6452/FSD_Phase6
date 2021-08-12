package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
@ApiModel(description="Entity class for Medicine.This entity class contains Medicine Name, Medicine Brand, Medicine Quantity and Medicine Price")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "ID of the user.It is the primery key and auto generated.",name="user ID",required=true,value="1")
	private int itemid;
	@ApiModelProperty(notes = "Name of the medicine.",required=true, value="Paracetamol")
	private String medicineName;
	@ApiModelProperty(notes = "Name of the brand to which the medicine belong.",required=true, value="DOLO")
	private String medicineBrand;
	@ApiModelProperty(notes = "Number of medicine available.",required=true, value="40")
	private int medicineQuantity;
	@ApiModelProperty(notes = "Price of medicine per strip.",required=true, value="$20")
	private double price;
	@Lob
	@Column(length = 100000, columnDefinition = "LONGBLOB")
	private byte[] picByte;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
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
	
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "Menu [itemid=" + itemid + ", medicineName=" + medicineName + ", medicineBrand=" + medicineBrand + ", medicineQuantity="
				+ medicineQuantity + ", price=" + price + "]";
	}
	
	
}
