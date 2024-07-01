package com.example.demo;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerUploadApplication.class, args);
//		generateOtpNo();
//	System.out.println("generate otp number" + generateOtpNo());
	}

	public static String generateOtpNo() {
		Random rnd = new Random();
		int numb = rnd.nextInt(9999);
		String res = String.format("%05d", numb + 999);
		String result = res;
		System.out.println("print otp" + res);
		return result;
	}

}