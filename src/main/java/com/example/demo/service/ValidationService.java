package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;

@Service
public class ValidationService {
	@Autowired
	private CustomerRepository customerRepository;
	
	

//	  public static final String EMAILPATTERN =
//	            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//	                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	  public boolean isValidEmail(String email) {
		    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		    return email.matches(regex);
		}

}
