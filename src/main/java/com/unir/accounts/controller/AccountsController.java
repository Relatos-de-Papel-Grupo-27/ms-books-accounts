package com.unir.accounts.controller;
import com.unir.accounts.data.model.Account;
import com.unir.accounts.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AccountsController {

    private final AccountService service;

    public AccountsController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {

        return ResponseEntity.ok(service.getAccounts());
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

}
