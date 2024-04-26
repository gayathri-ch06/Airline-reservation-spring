package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PaymentInfo;
import com.example.demo.services.PaymentInfoService;

@RestController
public class PaymentInforController {
	
	@Autowired
	private PaymentInfoService paymentService;
	
	@PostMapping("/addPayment")
	public void addPayment(@RequestBody PaymentInfo paymentInfo) {
		paymentService.addPaymentInfo(paymentInfo);
	}
	
	@PostMapping("/getPayment")
	public List<PaymentInfo> getPayment(@RequestBody String email) {
		return paymentService.getPaymentInfoByUserEmail(email);
	}

}
