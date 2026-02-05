package com.unir.accounts.controller;
import com.unir.accounts.common.ApiError;
import com.unir.accounts.data.model.Account;
import com.unir.accounts.service.AccountService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.Map;

import static jakarta.ws.rs.core.Response.ok;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Accounts", description = "Accounts API")
@Slf4j
public class AccountsController {

    private final AccountService service;

    public AccountsController(AccountService service) {
        this.service = service;
    }

    @GetMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cuentas retornadas"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<?> getAccounts() {
        try {
            return ResponseEntity.ok(service.getAccounts());
        } catch (Exception ex) {
            log.error("Error getting accounts", ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error("INTERNAL_ERROR", "Unexpected error"));
        }
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
        try {
            return service.getAccountById(id)
                    .<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElseGet(() ->
                            ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body(error(
                                            "ACCOUNT_NOT_FOUND",
                                            "Account with id " + id + " not found"
                                    ))
                    );
        } catch (Exception ex) {
            log.error("Error getting account {}", id, ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error("INTERNAL_ERROR", "Unexpected error"));
        }
    }

    private Map<String, Object> error(String code, String message) {
        return Map.of(
                "code", code,
                "message", message,
                "timestamp", LocalDateTime.now()
        );
    }

}
