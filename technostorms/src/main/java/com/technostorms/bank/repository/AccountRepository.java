package com.technostorms.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.technostorms.bank.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	
	

}
