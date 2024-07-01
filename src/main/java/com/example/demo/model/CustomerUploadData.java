package com.example.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CU_CUSTOMER_DATA")
public class CustomerUploadData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String customerName;
	private String emailId;
	private String mobileNumber;
	private Date currentDate;
	private Date dob;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<CUCUSTOMERADDRESS> cucustomeraddresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<CUCUSTOMERADDRESS> getCucustomeraddresses() {
		return cucustomeraddresses;
	}

	public void setCucustomeraddresses(List<CUCUSTOMERADDRESS> cucustomeraddresses) {
		this.cucustomeraddresses = cucustomeraddresses;
	}

	@Override
	public String toString() {
		return "CustomerUploadData [id=" + id + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", currentDate=" + currentDate + ", dob=" + dob
				+ ", cucustomeraddresses=" + cucustomeraddresses + "]";
	}

}
