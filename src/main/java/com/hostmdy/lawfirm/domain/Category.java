package com.hostmdy.lawfirm.domain;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank(message = "CategoryName should not be blank")
	@Column(updatable = false,unique = true)
	private String categoryName;
	
	@NotBlank(message = "Description should not be blank")
	private String description;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}


	public Category(Long id, String categoryName, String description) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
	}
	
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDate.now();
		
	}
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDate.now();
		
	}
	

	

	
	
	
	
	

}
