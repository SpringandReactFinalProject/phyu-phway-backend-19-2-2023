package com.hostmdy.lawfirm.service.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.repository.CourtRepository;
import com.hostmdy.lawfirm.service.CourtService;

@Service
public class CourtServiceImpl implements CourtService{
	
	private final CourtRepository courtRepository;
	
	@Autowired
	public CourtServiceImpl(CourtRepository courtRepository) {
		super();
		this.courtRepository = courtRepository;
	}


	@Override
	public Court SaveOrUpdate(Court court) {
		// TODO Auto-generated method stub
		return courtRepository.save(court);
	}


	@Override
	public List<Court> findAll() {
		// TODO Auto-generated method stub
		return (List<Court>) courtRepository.findAll();
	}


	@Override
	public Optional<Court> findById(Long id) {
		// TODO Auto-generated method stub
		return courtRepository.findById(id);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Court> courtOptional = courtRepository.findById(id);
		
		courtRepository.deleteById(courtOptional.get().getId());
	}

}
