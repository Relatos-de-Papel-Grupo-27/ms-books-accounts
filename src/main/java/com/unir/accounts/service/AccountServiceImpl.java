package com.unir.accounts.service;

import com.unir.accounts.data.AccountJpaRepository;
import com.unir.accounts.data.model.Account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountJpaRepository repository;

  public AccountServiceImpl(AccountJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Account> getAccounts() {
    return repository.findAll();
  }

  @Override
  public Optional<Account> getAccountById(Long id) {
    return repository.findById(id);
  }
}
