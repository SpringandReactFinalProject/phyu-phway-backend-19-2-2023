package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;


public interface CasesService {
	
	Cases saveOrUpdate(Cases cases,Long id);

	List<Cases> findAll();

	Optional<Cases> findById(Long id);
	
	void deleteById(Long id);

	//Cases saveOrUpdate(Cases cases, Long contractId);
	
	//Cases saveOrUpdate(Cases cases);
	
	
	//Cases updateCase(Cases cases) ;
	Cases updateCase(Cases cases) ;

}
