package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Payment;


public interface PaymentService {

	Payment SaveOrUpdate(Payment payment);
	
	List<Payment> findAll();
	
	Optional<Payment> findById(Long id);
	
	void deleteById(Long id);
}
