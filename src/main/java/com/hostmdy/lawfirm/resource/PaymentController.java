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
import com.hostmdy.lawfirm.domain.Payment;
import com.hostmdy.lawfirm.service.CourtService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;
import com.hostmdy.lawfirm.service.PaymentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins ="http://localhost:3000")
public class PaymentController {
	
		private final   PaymentService paymentService;
		private final  MapValidationErrorService mapErrorService;

		public PaymentController(PaymentService paymentService, MapValidationErrorService mapErrorService) {
			super();
			this.paymentService = paymentService;
			this.mapErrorService = mapErrorService;
		}

		@PostMapping("/create")
		public ResponseEntity<?> createPayment(@Valid @RequestBody Payment payment,BindingResult result){
			
			ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
			
			if(responseErrorObject != null) {
				return responseErrorObject;
			}
			Payment createdPayment = paymentService.SaveOrUpdate(payment);
			//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
			
			
			return new ResponseEntity<Payment>(createdPayment,HttpStatus.CREATED);
			
		}
		
		@GetMapping("/all")
		public List<Payment> findAll(){
			return paymentService.findAll();
		}
		
		@GetMapping("/id/{id}")
		public ResponseEntity<?> findById(@PathVariable Long id) {
			
			Optional<Payment> paymentOptional =  paymentService.findById(id);
			
			if(paymentOptional.isEmpty())
				return new ResponseEntity<String>("Payment with id ="+id+"is not found", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Payment>(paymentOptional.get(), HttpStatus.OK);
			
		}
		
		
		@DeleteMapping("/id/{id}")
		public ResponseEntity<Number> deleteById(@PathVariable Long id){
			paymentService.deleteById(id);
			
			return new ResponseEntity<Number>(id,HttpStatus.OK);
			
		}
		

}
