package com.hostmdy.lawfirm.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@NotBlank(message="Fullname must be filled")
	private String fullName;
	
	@Email(message="email is required")
	@NotBlank(message="email is required")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message="password is required")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@NotBlank(message="NRC is required")
	@Column(unique = true)
	private String nrc;
	
	@NotBlank(message="Phnone is required")
	private String phoneNo;
	
	@NotBlank(message="Address is required")
	private String address;
	
	
	
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER,
			cascade=CascadeType.REFRESH)
	private List<Cases>cases = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",
			fetch=FetchType.EAGER,
			cascade=CascadeType.REFRESH)
	private List<Appointment> appointment= new ArrayList<>();

}
