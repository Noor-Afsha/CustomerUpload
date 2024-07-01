package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.CustomerUploadData;
import com.example.demo.service.CustomerDataService;

@RestController
@RequestMapping("/customerData")
public class CustomerUploadController {

	@Autowired
	private CustomerDataService customerDataService;

	@PostMapping("/store")
	public ApiResponse create(@RequestBody CustomerUploadData customerUploadData) {
		return customerDataService.createService(customerUploadData);

	}

	@GetMapping("/get/{customerName}")
	public List<CustomerUploadData> getByNameController(@PathVariable String customerName) {
		return customerDataService.getByNameService(customerName);
	}

	@GetMapping("/getAll")
	public List<CustomerUploadData> getAll() {
		return customerDataService.getAllService();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteByIdController(@PathVariable int id) {

		return customerDataService.deleteByIdService(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAllController() {

		return customerDataService.deleteAllService();
	}

	@GetMapping("/delete/{customerName}")
	public void delete(@PathVariable String customerName) {
		customerDataService.deleteByCustomerName(customerName);
	}

	@GetMapping("/search/{emailId}")
	public String checkExistingEmailId(@PathVariable String emailId) {
		return customerDataService.checkMailIdService(emailId);
	}

}
