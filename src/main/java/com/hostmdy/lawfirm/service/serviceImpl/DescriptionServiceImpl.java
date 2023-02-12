package com.hostmdy.lawfirm.service.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hostmdy.lawfirm.domain.Description;
import com.hostmdy.lawfirm.repository.DescriptionRepository;
import com.hostmdy.lawfirm.service.DescriptionService;
@Service
public class DescriptionServiceImpl implements DescriptionService{
	
	private final DescriptionRepository descriptionRepository;
	

	public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
		super();
		this.descriptionRepository = descriptionRepository;
	}

	@Override
	public Description SaveOrUpdate(Description description) {
		// TODO Auto-generated method stub
		return descriptionRepository.save(description);
	}

	@Override
	public List<Description> findAll() {
		// TODO Auto-generated method stub
		return (List<Description>) descriptionRepository.findAll();
	}

	@Override
	public Optional<Description> findById(Long id) {
		// TODO Auto-generated method stub
		return descriptionRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		descriptionRepository.deleteById(id);
		
	}

}
