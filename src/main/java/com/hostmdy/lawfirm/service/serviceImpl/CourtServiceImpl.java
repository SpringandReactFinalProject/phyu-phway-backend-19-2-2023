package com.hostmdy.lawfirm.service.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.repository.CasesRepository;
import com.hostmdy.lawfirm.repository.CourtRepository;
import com.hostmdy.lawfirm.service.CourtService;

@Service
public class CourtServiceImpl implements CourtService{
	
	private final CourtRepository courtRepository;
	private final CasesRepository casesRepository;
	
	@Autowired
	public CourtServiceImpl(CourtRepository courtRepository,CasesRepository casesRepository) {
		super();
		this.courtRepository = courtRepository;
		this.casesRepository = casesRepository;
	}
	
	@Override
	public Court SaveOrUpdate(Court court, Long caseId) {
		// TODO Auto-generated method stub
		Cases cases = casesRepository.findById(caseId).get();
		
		cases.setCourt(court);
		court.getCases().add(cases);
				
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


	//form link
	@Override
	public Optional<Court> getCourtById(Long id) {
		// TODO Auto-generated method stub
		return courtRepository.getCourtById(id);
	}







	






	

	

	





	

	
		
		


	
//	public Court updateCourt(Court court,String courtName) {
//		
//		
//		List<Cases> casesOpt = courtRepository.findBy
//		Cases cases = casesOpt.get(0);
//		
//		if(cases != null) {
//			court.setCases(cases);
//			
//			
//		}
//		return courtRepository.save(court);	}

}

	
