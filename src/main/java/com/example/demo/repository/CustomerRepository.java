package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerUploadData;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerUploadData, Integer> {

	public List<CustomerUploadData> findByCustomerName(String customerName);

	public CustomerUploadData getByCustomerName(String customerName);

	public List<CustomerUploadData> findByEmailId(String emailId);
	
}
