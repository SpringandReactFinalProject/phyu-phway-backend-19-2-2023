package com.hostmdy.lawfirm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationErrorsMapService {
	
	ResponseEntity<?> validate(BindingResult result);

}
