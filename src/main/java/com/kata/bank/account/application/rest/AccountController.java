package com.kata.bank.account.application.rest;

import com.kata.bank.account.application.mapper.AccountMapper;
import com.kata.bank.account.application.request.DepositRequest;
import com.kata.bank.account.application.request.StatementResponse;
import com.kata.bank.account.application.request.WithdrawRequest;
import com.kata.bank.account.domain.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-management")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<Boolean> makeDeposit(@RequestBody DepositRequest depositRequest) {

        return ResponseEntity.ok(accountService.makeDeposit(depositRequest.getAmount()));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Boolean> makeWithdrawal(@RequestBody WithdrawRequest withdrawRequest) {

        return ResponseEntity.ok(accountService.makeWithdrawal(withdrawRequest.getAmount()));
    }


    @GetMapping("/statements")
    public ResponseEntity<List<StatementResponse>> getStatements() {
        return ResponseEntity.ok(AccountMapper.mapToStatementResponses(accountService.getStatements()));
    }

}
