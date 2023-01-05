package com.hostmdy.lawfirm.service.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Lawer;
import com.hostmdy.lawfirm.repository.LawerRepository;
import com.hostmdy.lawfirm.service.LawerService;

@Service
public class LawerServiceImpl implements LawerService {

	 private final LawerRepository lawerRepository;
	
	 
	@Autowired 
	public LawerServiceImpl(LawerRepository lawerRepository) {
		super();
		this.lawerRepository = lawerRepository;
	}

	@Override
	public Lawer saveOrUpdate(Lawer lawer) {
		// TODO Auto-generated method stub
		return lawerRepository.save(lawer);
	}

	@Override
	public List<Lawer> fingAll() {
		// TODO Auto-generated method stub
		return (List<Lawer>) lawerRepository.findAll();
	}

	@Override
	public Optional<Lawer> findById(Long id) {
		// TODO Auto-generated method stub
		return lawerRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		lawerRepository.deleteById(id);
		
	}

	
}
