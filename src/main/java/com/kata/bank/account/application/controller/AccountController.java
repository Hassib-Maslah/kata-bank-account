package com.kata.bank.account.application.controller;

import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account-management/deposit")
    public ResponseEntity<Boolean> makeDeposit(@RequestBody DepositRequest depositRequest) {

        return ResponseEntity.ok(accountService.makeDeposit(depositRequest));
    }

}