package com.hostmdy.lawfirm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hostmdy.lawfirm.service.ValidationErrorsMapService;

@Service
public class ValidationErrorMapServiceImpl implements ValidationErrorsMapService {

	@Override
	public ResponseEntity<?> validate(BindingResult result) {
		// TODO Auto-generated method stub
		//	testing validation	
//		if(result.hasErrors())
//			return new ResponseEntity<String>("Ivallid Passing Argurments",HttpStatus.BAD_REQUEST);
//		Lawer createLawer = lawerService.saveOrUpdate(lawer);
		
		if(result.hasErrors())
		{
			Map<String,String> errorMap = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			
			for (final FieldError fieldError : errors) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
				
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		
		}
		
		return null;
	}

}
