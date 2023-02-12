package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Description;


public interface DescriptionService {
	
	Description SaveOrUpdate(Description description);
	
	List<Description> findAll();
	
	Optional<Description> findById(Long id);
	
	void deleteById(Long id);

}
