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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.repository.CategoryRepository;
import com.hostmdy.lawfirm.service.CategoryService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins ="http://localhost:3000")
public class CategoryController {
	
	private final CategoryService categoryService;
	private final MapValidationErrorService mapErrorService;
	
	
	@Autowired
	public CategoryController(CategoryService categoryService,MapValidationErrorService mapErrorService) {
		
		super();
		this.categoryService = categoryService;
		this.mapErrorService = mapErrorService;
		
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createCategory(@Valid @RequestBody Category category,BindingResult result){
		
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		Category createdCategory = categoryService.SaveOrUpdate(category);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<Category>(createdCategory,HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/all")
	public List<Category> findAll(){
		return categoryService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		Optional<Category> categoryOptional =  categoryService.findById(id);
		
		if(categoryOptional.isEmpty())
			return new ResponseEntity<String>("Category with id ="+id+"is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Category>(categoryOptional.get(), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Number> deleteById(@PathVariable Long id){
		categoryService.deleteById(id);
		
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	

}
