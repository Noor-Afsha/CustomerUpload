package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.CUCUSTOMERADDRESS;
import com.example.demo.model.CustomerUploadData;
import com.example.demo.repository.CustAddressRepository;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerDataService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustAddressRepository CustAddressRepository;
	
	@Autowired
	private ValidationService validationService;

	public ApiResponse createService(CustomerUploadData customerUploadData) {

		Date currentDate = new Date();
		int age = (int) ((currentDate.getTime() - customerUploadData.getDob().getTime())
				/ (1000 * 60 * 60 * 24 * 365.25));


		int home = 0;
		int office = 0;

		for (CUCUSTOMERADDRESS c1 : customerUploadData.getCucustomeraddresses()) {

			if (!c1.getAddressType().equals("home") && !c1.getAddressType().equals("office")) {

				return ApiResponse.failed("Address type is not proper");
			}

			if (c1.getAddressType().equals("home")) {
				home++;
			} else if (c1.getAddressType().equals("office")) {
				office++;
			}
		}

		if (customerUploadData.getCucustomeraddresses().size() != 2) {
			return ApiResponse.failed("only two address are allowed");
		}

		if (home != 1 || office != 1) {
			return ApiResponse.failed("address should contain only one home & office");
		}

		CustomerUploadData existingCustomer = customerRepository
				.getByCustomerName(customerUploadData.getCustomerName());
		if (existingCustomer != null) {
			return ApiResponse.failed("Customer with the same name already exists try for another customer name");
		}

		if (customerUploadData.getCustomerName().length() < 4) {
			return ApiResponse.failed("customer name shoul not be less than 4 char");
		}
		if (!Character.isUpperCase(customerUploadData.getCustomerName().charAt(0))) {
			return ApiResponse.failed("Customer name always start with upper case");
		}
		String emailId = "";
		if (validationService.isValidEmail(emailId)) {
			return ApiResponse.failed("emailId should not be  null");
		}

		if (customerUploadData.getMobileNumber().toString().length() != 10) {
			return ApiResponse.failed("mobile number should be 10 didgit only");
		}
		if (age < 18) {
			return ApiResponse.failed("Can not fill the form because it seems under age");
		}

		else {
			customerRepository.save(customerUploadData);
			return ApiResponse.success("saved the record");
		}

	}

	private boolean isValidEmail(Object emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CustomerUploadData> getByNameService(String customerName) {

		System.out.println("Inside the getBy name service method is executed");

		return customerRepository.findByCustomerName(customerName);
	}

	public List<CustomerUploadData> getAllService() {

		return customerRepository.findAll();
	}

	public String deleteByIdService(int id) {

		System.out.println(("Inside the deleteBy Id service method is executed"));

		customerRepository.deleteById(id);

		return "record deleted by Id succeessfuly";
	}

	public String deleteAllService() {

		System.out.println("Inside the deleteAll service method is executed");

		customerRepository.deleteAll();

		return "From the db all records deleted successfully";

	}

	@Transactional
	public void deleteByCustomerName(String customerName) {
		System.out.println("print");

		List<CustomerUploadData> customerUploadDatas = customerRepository.findByCustomerName(customerName);

		for (CustomerUploadData customerUploadData : customerUploadDatas) {
			customerRepository.deleteById(customerUploadData.getId());
		}

	}

	public String checkMailIdService(String emaiId) {
		System.out.println("Inside the check mail id method is executed");
		try {
			System.out.println("inside the try and catch block");

			List<CustomerUploadData> customerUploadDatalist = customerRepository.findByEmailId(emaiId);

			if (customerUploadDatalist == null || customerUploadDatalist.isEmpty()) {
				return "emailId does not matched with exsiting in db";
			} else {
				return "email id matched";
			}

		} catch (Exception e) {
			System.out.println("operation failed" + e);
			e.printStackTrace();
		}
		return emaiId;

	}

}
