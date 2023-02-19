package com.hostmdy.lawfirm.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.repository.CategoryRepository;
import com.hostmdy.lawfirm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category SaveOrUpdate(Category category) {
		// TODO Auto-generated method stub

		
//			Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
//			
//			if(categoryOptional.isPresent()) {
//				category.setId(categoryOptional.get().getId());
//			}
		
		
		return categoryRepository.save(category);
	}
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		//categoryRepository.deleteById(id);
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		
		categoryRepository.deleteById(categoryOptional.get().getId());
		
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		Long categoryId = category.getId();
		Cases cases = categoryRepository.findById(categoryId).get().getCases();
		
		if(cases != null) {
			category.setCases(cases);
			cases.setCategory(category);
		}
		return categoryRepository.save(category);
	}


	

	


	
}

	

	


		
	

	

	
	

	
	
	


