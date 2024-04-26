package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PaymentInfo;
import com.example.demo.repositories.PaymentInfoRepository;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInfoService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    
    @Autowired
	private TextEncryptor textEncryptor;
	
    // Method to add payment information
    public void addPaymentInfo(PaymentInfo paymentInfo) {
        paymentInfoRepository.save(encryptCard(paymentInfo));
    }

    // Method to retrieve all payment information
    public List<PaymentInfo> getAllPaymentInfo() {
        return paymentInfoRepository.findAll();
    }
    
    public List<PaymentInfo> getPaymentInfoByUserEmail(String email) {
    	List<PaymentInfo> result = paymentInfoRepository.findByUserEmail(email);
    	List<PaymentInfo> paymentList = new ArrayList<PaymentInfo>();
    	for(PaymentInfo info : result) {
    		paymentList.add(decryptCard(info));
    	}
        return paymentList;
    }
 
    // Method to retrieve payment information by card number
    public PaymentInfo getPaymentInfoByCardNumber(String cardNumber) {
        return decryptCard(paymentInfoRepository.findByCardNumber(cardNumber));
    }

    // Method to update payment information
    public void updatePaymentInfo(String cardNumber, PaymentInfo updatedPaymentInfo) {
        PaymentInfo existingPaymentInfo = paymentInfoRepository.findByCardNumber(cardNumber);
        if (existingPaymentInfo != null) {
            // Update payment information fields
            existingPaymentInfo.setUserEmail(updatedPaymentInfo.getUserEmail());
            existingPaymentInfo.setExpiryDate(updatedPaymentInfo.getExpiryDate());
            existingPaymentInfo.setNameOnCard(updatedPaymentInfo.getNameOnCard());
            existingPaymentInfo.setSecurityCode(updatedPaymentInfo.getSecurityCode());
            existingPaymentInfo.setStreet(updatedPaymentInfo.getStreet());
            existingPaymentInfo.setCity(updatedPaymentInfo.getCity());
            existingPaymentInfo.setState(updatedPaymentInfo.getState());
            existingPaymentInfo.setZipcode(updatedPaymentInfo.getZipcode());
            // Save updated payment information
            paymentInfoRepository.save(existingPaymentInfo);
        } else {
            // Handle payment information not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete payment information by card number
    public void deletePaymentInfo(String cardNumber) {
        paymentInfoRepository.deleteByCardNumber(cardNumber);
    }
    
    public PaymentInfo encryptCard(PaymentInfo card) {
		  
		  try {
			card.setCardNumber(textEncryptor.encrypt(card.getCardNumber()));
			card.setExpiryDate(textEncryptor.encrypt(card.getExpiryDate()));
			card.setNameOnCard(textEncryptor.encrypt(card.getNameOnCard()));
			card.setSecurityCode(textEncryptor.encrypt(card.getSecurityCode()));
			card.setStreet(textEncryptor.encrypt(card.getStreet()));
			card.setCity(textEncryptor.encrypt(card.getCity()));
			card.setState(textEncryptor.encrypt(card.getState()));
			card.setZipcode(textEncryptor.encrypt(card.getZipcode()));


		  } catch (Exception e) {
			e.printStackTrace();
		  }
		  return card;
		  
		  
	  }
	  
	  public PaymentInfo decryptCard(PaymentInfo card) {
		  
		  try {
			card.setCardNumber(textEncryptor.decrypt(card.getCardNumber()));
			card.setExpiryDate(textEncryptor.decrypt(card.getExpiryDate()));
			card.setNameOnCard(textEncryptor.decrypt(card.getNameOnCard()));
			card.setSecurityCode(textEncryptor.decrypt(card.getSecurityCode()));
			card.setStreet(textEncryptor.decrypt(card.getStreet()));
			card.setCity(textEncryptor.decrypt(card.getCity()));
			card.setState(textEncryptor.decrypt(card.getState()));
			card.setZipcode(textEncryptor.decrypt(card.getZipcode()));


		  } catch (Exception e) {
			e.printStackTrace();
		  }
		  return card;
		  
		  
	  }
}
