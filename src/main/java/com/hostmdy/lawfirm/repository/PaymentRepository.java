package com.hostmdy.lawfirm.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
