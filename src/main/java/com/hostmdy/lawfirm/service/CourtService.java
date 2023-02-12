package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Court;

public interface CourtService {
	
	Court SaveOrUpdate(Court court);
	
	List<Court> findAll();
	
	Optional<Court> findById(Long id);
	
	void deleteById(Long id);
	
	
	

}
