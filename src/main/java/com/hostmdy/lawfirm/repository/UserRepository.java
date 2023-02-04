package com.hostmdy.lawfirm.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.User;

public interface LawFirmRepository extends CrudRepository<User, Long>{

}
