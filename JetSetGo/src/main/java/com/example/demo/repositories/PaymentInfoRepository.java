package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PaymentInfo;



public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

	PaymentInfo findByCardNumber(String cardNumber);

	void deleteByCardNumber(String cardNumber);

	List<PaymentInfo> findByUserEmail(String email);
}