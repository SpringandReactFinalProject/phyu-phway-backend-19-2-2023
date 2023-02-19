package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Category;

public interface CategoryService {
	
	Category SaveOrUpdate(Category category);
	
	//New
//	Category Save(Category category);
//	
//	Category Update(Long id,String description);
	

	List<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	void deleteById(Long id);
	
	Category updateCategory (Category category);
	
	
	

}
