package com.technostorms.bank.controller;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technostorms.bank.model.Account;
import com.technostorms.bank.repository.AccountRepository;
import com.technostorms.bank.service.ICoreService;

@RestController
@RequestMapping("Bank")
public class AccountController {
	
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ICoreService service;

	@PostMapping("createAccount")
	public Account createAccount(@Valid @RequestBody Account account) {
		return 	accountRepository.save(account);
	}
	
	@PostMapping("credit")
	public ResponseEntity<String>  creditAmt(@RequestBody Account account){
		service.credit(account,account.getBalance());
		return new ResponseEntity<String>(new String("SccessFully credited"),HttpStatus.OK);
	}
	
	@PostMapping("debit")
	public ResponseEntity<String> withDraw(@RequestBody Account account){
		service.withDrawAmount(account,null);
		return new ResponseEntity<String>(new String("SccessFully Debited"),HttpStatus.OK);
	}
	
	@PostMapping("Transfer")
	public ResponseEntity<String> transferAmont(@RequestBody Account account,
			@QueryParam("transferID") String transferID){
		service.withDrawAmount(account,transferID);
		return new ResponseEntity<String>(new String("SccessFully transfered"),HttpStatus.OK);
	}
	
}
