package com.unir.accounts.service;

import com.unir.accounts.data.AccountJpaRepository;
import com.unir.accounts.data.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountJpaRepository repository;

  public AccountServiceImpl(AccountJpaRepository repository) {
    this.repository = repository;
  }


  @Override
  public Account getAccountById(Long id) {
    return repository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado por Id: " + id));
  }


  @Override
  public List<Account> getAccounts() {
    return repository.findAll();
  }
}
