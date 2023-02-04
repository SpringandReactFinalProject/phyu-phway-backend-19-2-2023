package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private Double cost;
	private String nrc;
	private String phoneNo;
	private String photo;
	private Boolean status;
	private String accountName;
	private Role role;
	private String email;
	private String password;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	public User(String firstName, String middleName, String lastName, String address, Double cost, String nrc,
			String phoneNo, String photo, Boolean status, String accountName, Role role, String email,
			String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.cost = cost;
		this.nrc = nrc;
		this.phoneNo = phoneNo;
		this.photo = photo;
		this.status = status;
		this.accountName = accountName;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	public User(Long id, String firstName, String middleName, String lastName, String address, Double cost, String nrc,
			String phoneNo, String photo, Boolean status, String accountName, Role role, String email,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.cost = cost;
		this.nrc = nrc;
		this.phoneNo = phoneNo;
		this.photo = photo;
		this.status = status;
		this.accountName = accountName;
		this.role = role;
		this.email = email;
		this.password = password;
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
