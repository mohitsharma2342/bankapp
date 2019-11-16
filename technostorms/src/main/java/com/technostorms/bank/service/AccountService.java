package com.technostorms.bank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.technostorms.bank.model.Account;
import com.technostorms.bank.repository.AccountRepository;

@Service
public class AccountService implements ICoreService {
	
	@Autowired
	private AccountRepository accountRepository;

	public void withDrawAmount(Account account,String transferId) {
		Account sourceAccount = accountRepository.findById(account.getAccountId()).get();
		if(transferId!=null) {
			Long transferAccountId  = Long.valueOf(transferId);
			Account destinatinationAccount = accountRepository.findById(transferAccountId).get();
			if(destinatinationAccount.getBalance()!=null) {
				credit(destinatinationAccount,account.getBalance());
				debit(sourceAccount,account.getBalance());
			}
		}else {
			  debit(sourceAccount,account.getBalance());
		}
	}

	
	private void debit(Account account, BigDecimal balance) {
		 if(account.getBalance()!=null) {
			 account.setBalance( account.getBalance().subtract(balance));
			 accountRepository.save(account);
		   }
	}

	public void credit(Account account, BigDecimal newAddingAmt) {
		  Account oAccount = accountRepository.findById(account.getAccountId()).get();
		  BigDecimal balance =new BigDecimal(0);
		  if(oAccount.getBalance()!=null) {
			  balance =  oAccount.getBalance().add(newAddingAmt);
		  }else {
			  balance = balance.add(newAddingAmt);
		  }
		  oAccount.setBalance(balance);
		  accountRepository.save(oAccount);
	}


	public Account search(String firstName,String accountId) {
		List<Account> accounts = (List<Account>) accountRepository.findAll();
		Account account = new Account();
		if(accountId!=null) {
			account=accounts.stream().map(a->a).filter(a->a.getAccountId().equals(accountId)).
					findAny().orElseThrow(() -> new UsernameNotFoundException("No user found with username " + firstName));
			}
		if(firstName!=null) {
		account=accounts.stream().map(a->a).filter(a->a.getUser().getFirstName().equals(firstName)).
				findAny().orElseThrow(() -> new UsernameNotFoundException("No user found with username " + firstName));
		}
		
		return account;
	}
}

