package com.technostorms.bank.service;

import java.math.BigDecimal;

import com.technostorms.bank.model.Account;

public interface ICoreService {

	void withDrawAmount(Account account, String transferID);

	void credit(Account account, BigDecimal balance);

	Account search(String firstName,Long accountId);

	Account findById(Long accountId);

}
