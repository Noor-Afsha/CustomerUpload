package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CU_CUSTOMER_ADDRESS")
public class CUCUSTOMERADDRESS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	private String addressType;
	private String address;
	private String city;
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CUCUSTOMERADDRESS [addId=" + addId + ", addressType=" + addressType + ", address=" + address + ", city="
				+ city + "]";
	}

	
}
