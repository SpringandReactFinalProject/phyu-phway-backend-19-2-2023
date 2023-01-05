package com.hostmdy.lawfirm.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Fullname must be filled")
	private String fullName;

	@Email(message = "Enter your email")
	@NotBlank(message = "email is required")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "password is required")
	private String password;

	@Transient
	private String comfirmPassword;

//	@OneToMany(mappedBy = "admin",fetch=FetchType.EAGER,
//			cascade= CascadeType.REFRESH,
//			orphanRemoval = true)
//	private List<Lawer>lawer = new ArrayList<>();
//	
//	@OneToMany(mappedBy = "admin",  fetch=FetchType.EAGER,
//			cascade= CascadeType.REFRESH,
//			orphanRemoval = true)
//	private List<User>user = new ArrayList<>();
}
