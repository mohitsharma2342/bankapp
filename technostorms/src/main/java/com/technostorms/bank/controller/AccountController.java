package com.technostorms.bank.controller;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technostorms.bank.model.Account;
import com.technostorms.bank.repository.AccountRepository;
import com.technostorms.bank.service.ICoreService;
import com.technostorms.bank.utill.CustomErrorType;
import com.technostorms.bank.utill.IConstant;

@RestController
@RequestMapping("Bank")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ICoreService service;

	@PostMapping("createAccount")
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PostMapping("credit")
	public ResponseEntity<CustomErrorType> creditAmt(@RequestBody Account account) {
		if (service.findById(account.getAccountId()) != null) {
			service.credit(account, account.getBalance());
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.CREDIT_MESSAGE), HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.USER_NOTFOUND+ account.getAccountId()),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("debit")
	public ResponseEntity<CustomErrorType> withDraw(@RequestBody Account account) {
		if (service.findById(account.getAccountId()) != null) {
			service.withDrawAmount(account, null);
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.DEBIT_MESSAGE), HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.USER_NOTFOUND+ account.getAccountId()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("Transfer")
	public ResponseEntity<CustomErrorType> transferAmont(@RequestBody Account account,
			@QueryParam("transferID") String transferID) {
		service.withDrawAmount(account, transferID);
		return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.TRANSFERED_MESSAGE), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<CustomErrorType> find(@QueryParam("firstName") String firstName,
			@QueryParam("accountId") Long accountId) {
		if(service.search(firstName, accountId)!=null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(HttpStatus.FOUND.toString(),service.search(firstName, accountId)), 
					HttpStatus.OK);
		}else {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType(IConstant.USER_NOTFOUND+ accountId +
					" or "+firstName), 
					HttpStatus.BAD_REQUEST);
		}
	}

}
