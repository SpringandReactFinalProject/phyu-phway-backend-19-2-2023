package com.hostmdy.lawfirm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Court;

public interface CourtRepository extends CrudRepository<Court, Long>{
	
	//form link
	Optional<Court> getCourtById(Long id);
	
Optional<Court> findByCourtName(String courtName);

Optional<Court>  findById(Long id);
}
