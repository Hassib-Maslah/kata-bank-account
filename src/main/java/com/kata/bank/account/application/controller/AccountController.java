package com.kata.bank.account.application.controller;

import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.WithdrawRequest;
import com.kata.bank.account.domain.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/account-management/withdraw")
    public ResponseEntity<Boolean> makeWithdrawal(@RequestBody WithdrawRequest withdrawRequest) {

        return ResponseEntity.ok(accountService.makeWithdrawal(withdrawRequest));
    }


    @GetMapping("/account-management/statements")
    public ResponseEntity<List<Statement>> getStatements() {
        return ResponseEntity.ok(accountService.getStatements());
    }

}
