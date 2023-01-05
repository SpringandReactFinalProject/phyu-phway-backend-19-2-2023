package com.hostmdy.lawfirm.service;



import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Lawer;

public interface LawerService {
	
	Lawer saveOrUpdate(Lawer lawer);
	List<Lawer> fingAll();
	Optional<Lawer> findById(Long id);	
	
	void deleteById(Long id);
	 
	
	

}
