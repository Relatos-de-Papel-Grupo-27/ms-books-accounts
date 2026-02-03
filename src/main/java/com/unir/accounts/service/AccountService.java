package com.unir.accounts.service;

import com.unir.accounts.data.model.Account;

import java.util.List;

public interface AccountService {
	
//	Order createOrder(OrderRequest request);

	List<Account> getAccounts();

	Account getAccountById(Long id);

}
