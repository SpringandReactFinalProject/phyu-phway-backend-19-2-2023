package com.hostmdy.lawfirm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationErrorService {
	ResponseEntity<?> validate(BindingResult result);

}
