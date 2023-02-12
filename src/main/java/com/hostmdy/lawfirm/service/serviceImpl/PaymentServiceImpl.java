package com.hostmdy.lawfirm.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.domain.Payment;
import com.hostmdy.lawfirm.repository.CourtRepository;
import com.hostmdy.lawfirm.repository.PaymentRepository;
import com.hostmdy.lawfirm.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private  final PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment SaveOrUpdate(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> findById(Long id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
//		Optional<Payment> paymentOpt = paymentRepository.findById(id);
		
		paymentRepository.deleteById(id);
		
	}
	
	

}
