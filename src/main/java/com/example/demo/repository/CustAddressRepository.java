package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CUCUSTOMERADDRESS;

@Repository
public interface CustAddressRepository extends JpaRepository<CUCUSTOMERADDRESS, Integer> {


}
