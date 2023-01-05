package com.hostmdy.lawfirm.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.service.UserService;
import com.hostmdy.lawfirm.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService userService;
	private final ValidationErrorsMapService errorMapService;
	
	@Autowired
	public UserController(UserService userService, ValidationErrorsMapService errorMapService) {
		super();
		this.userService = userService;
		this.errorMapService = errorMapService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result){
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);

		if (responseErrorObject != null)
			return responseErrorObject;
		
		User createUser = userService.saveOrUpdate(user);
		
		return new ResponseEntity<User>( createUser,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/all")
	public List<User> findAllUser(){
		return userService.findAll();
		}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOptional = userService.findById(id);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with id ="+id+" not found",HttpStatus.NOT_FOUND);
			
			
		return new ResponseEntity<User>( userOptional.get(),HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable Long id){
		userService.deleteById(id);
		
		return new ResponseEntity<String>("User with id ="+id+"is deleted",HttpStatus.OK);
	}
}
