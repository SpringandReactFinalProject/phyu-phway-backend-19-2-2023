package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.User;

public interface UserService {

	User saveOrUpdate(User user);
	
	List<User> findAll();
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
	
}
