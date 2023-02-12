package com.hostmdy.lawfirm.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.service.CourtService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/court")
@CrossOrigin(origins ="http://localhost:3000")
public class CourtController {
	private final  CourtService courtService;
	private final MapValidationErrorService mapErrorService;
	
	@Autowired
	public CourtController(CourtService courtService, MapValidationErrorService mapErrorService) {
		super();
		this.courtService = courtService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCourt(@Valid @RequestBody Court court,BindingResult result){
		
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		Court createdCourt = courtService.SaveOrUpdate(court);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<Court>(createdCourt,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Court> findAll(){
		return courtService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		Optional<Court> courtOptional =  courtService.findById(id);
		
		if(courtOptional.isEmpty())
			return new ResponseEntity<String>("Court with id ="+id+"is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Court>(courtOptional.get(), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Number> deleteById(@PathVariable Long id){
		courtService.deleteById(id);
		
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	

}
