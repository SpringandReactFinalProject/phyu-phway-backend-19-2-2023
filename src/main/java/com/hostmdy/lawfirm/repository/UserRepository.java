package com.hostmdy.lawfirm.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	

}
