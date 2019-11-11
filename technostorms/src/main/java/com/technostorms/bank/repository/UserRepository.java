package com.technostorms.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.technostorms.bank.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{

	User findByfirstName(String firstName);

}
