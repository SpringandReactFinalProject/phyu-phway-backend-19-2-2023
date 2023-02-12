package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;

import org.springframework.validation.FieldError;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	
	
	
	private String description;
	
	private String licenseNo;
	private String field;
	private LocalDate licenseExpiredDate;
	public Description(String description, String licenseNo, String field, LocalDate licenseExpiredDate) {
		super();
		this.description = description;
		this.licenseNo = licenseNo;
		this.field = field;
		this.licenseExpiredDate = licenseExpiredDate;
	}
	public Description(Long id, String description, String licenseNo, String field, LocalDate licenseExpiredDate) {
		super();
		this.id = id;
		this.description = description;
		this.licenseNo = licenseNo;
		this.field = field;
		this.licenseExpiredDate = licenseExpiredDate;
	}

	

	
	
	
	
	

}
