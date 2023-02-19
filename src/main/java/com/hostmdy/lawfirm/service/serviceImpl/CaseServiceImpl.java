package com.hostmdy.lawfirm.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.repository.CasesRepository;
import com.hostmdy.lawfirm.repository.CategoryRepository;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.repository.CourtRepository;
import com.hostmdy.lawfirm.service.CasesService;

@Service
public class CaseServiceImpl implements CasesService  {

	private final CasesRepository casesRepository;
	private final CategoryRepository categoryRepository;
	private final CourtRepository courtRepository;
	
	
	@Autowired
	public CaseServiceImpl(CasesRepository casesRepository, CategoryRepository categoryRepository,CourtRepository courtRepository) {
		super();
		this.casesRepository = casesRepository;
		this.categoryRepository = categoryRepository;
		this.courtRepository = courtRepository;
		
	}
	
	
	@Override
	public Cases saveOrUpdate(Cases cases, Long id) {
		
		Category category = categoryRepository.findById(id).get();
		//category case
		category.setCases(cases);
		cases.setCategory(category);
		
		//court case
				
		return casesRepository.save(cases);
	}
//ma chit su
//	@Override
//	public Cases saveOrUpdate(Cases cases,Long contractId) {
//		// TODO Auto-generated method stub
//		Contract contract=contractRepository.findById(contractId).get();
//		
//		//contract - case (one to one)
//		contract.setCases(cases);
//		//cases.setContract(contract);
//		
//        
//       
//		return casesRepository.save(cases);
//	}

	@Override
	public List<Cases> findAll() {
		// TODO Auto-generated method stub
		return (List<Cases>) casesRepository.findAll();
	}

	@Override
	public Optional<Cases> findById(Long id) {
		// TODO Auto-generated method stub
		return casesRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		//Optional<Cases> caseOptional = casesRepository.findById(id);
		
		///casesRepository.deleteById(caseOptional.get().getId());
		casesRepository.deleteById(id);
	}


	@Override
	public Cases updateCase(Cases cases) {
		
		Long caseId = cases.getId();
		Court court = casesRepository.findById(caseId).get().getCourt();
		
		if(court != null) {
			cases.setCourt(court);
		}
				return casesRepository.save(cases);
			}
		
	}


	
	
	

//	@Override
//	public Cases updateCase(Cases cases) {
//		
//		Court court =checkCourt(id); 
//		return casesRepository.save(cases);
//	}

	

//	@Override
//	public Cases updateCase(Cases cases) {
//		// TODO Auto-generated method stub
//		Long caseId=cases.getId();
//		Category categories=casesRepository.findById(caseId).get().getCategory();
//		
//		if(categories !=null) {
//			//contract-case
//			cases.setCategory(categories);
//			//cases.setContract(contract);
//			
//		}				
//				
//				return casesRepository.save(cases);
//	}

	

	


