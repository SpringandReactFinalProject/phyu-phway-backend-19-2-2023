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

import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.domain.Description;
import com.hostmdy.lawfirm.repository.DescriptionRepository;
import com.hostmdy.lawfirm.service.CourtService;
import com.hostmdy.lawfirm.service.DescriptionService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/description")
@CrossOrigin(origins ="http://localhost:3000")
public class DescriptionController {
	
	private final  DescriptionService descriptionService;
	private final MapValidationErrorService mapErrorService;
	
	
	
	public DescriptionController(DescriptionService descriptionService, MapValidationErrorService mapErrorService) {
		super();
		this.descriptionService = descriptionService;
		this.mapErrorService = mapErrorService;
	}

	@PostMapping("/create")
	public ResponseEntity<?> createDescription(@Valid @RequestBody Description description,BindingResult result){
		
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		Description createDescription = descriptionService.SaveOrUpdate(description);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<Description>(createDescription,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Description> findAll(){
		return descriptionService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		Optional<Description> descriptionOptional =  descriptionService.findById(id);
		
		if(descriptionOptional.isEmpty())
			return new ResponseEntity<String>("Description with id ="+id+"is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Description>(descriptionOptional.get(), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Number> deleteById(@PathVariable Long id){
		descriptionService.deleteById(id);
		
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}

}
