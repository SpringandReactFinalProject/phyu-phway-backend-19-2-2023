package com.hostmdy.lawfirm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Court;

import jakarta.persistence.criteria.CriteriaBuilder.Case;

public interface CasesRepository extends CrudRepository<Cases, Long> {
	
	Optional<Cases>  findById(Long id);
	
	
	

}
