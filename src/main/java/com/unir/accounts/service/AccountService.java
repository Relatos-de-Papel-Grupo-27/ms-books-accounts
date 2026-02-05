package com.unir.accounts.service;

import com.unir.accounts.data.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
	
//	Order createOrder(OrderRequest request);

	List<Account> getAccounts();

	Optional<Account> getAccountById(Long id);

}
