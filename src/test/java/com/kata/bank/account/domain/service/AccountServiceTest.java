package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.WithdrawRequest;
import com.kata.bank.account.domain.enums.Operation;
import com.kata.bank.account.domain.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    void shouldCreateAccount_thenSaveIt() {
        // arrange
        Account account = new Account("Jordan", 150L);
        // act
        Account savedAccount = accountService.saveAccount(account);
        // assert
        assertNotNull(savedAccount);
        assertThat(savedAccount.getHolder()).isEqualTo("Jordan");
        assertThat(savedAccount.getAmount()).isEqualTo(150L);
    }

    @Test
    void shouldMakeDeposit_thenReturnTrue() {
        // arrange
        DepositRequest depositRequest = new DepositRequest(100L);
        // act
        boolean result = accountService.makeDeposit(depositRequest);
        // assert
        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(200L);
    }

    @Test
    void shouldMakeWithdrawal_thenReturnTrue() {
        // arrange
        WithdrawRequest withdrawRequest = new WithdrawRequest(50L);
        // act
        boolean result = accountService.makeWithdrawal(withdrawRequest);
        // assert
        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(50L);
    }

    @Test
    void shouldNotMakeWithdrawal_thenReturnFalse() {
        // arrange
        WithdrawRequest withdrawRequest = new WithdrawRequest(500L);
        // act
        boolean result = accountService.makeWithdrawal(withdrawRequest);
        // assert
        assertThat(result).isFalse();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(100L);
    }

    @Test
    void shouldCreateStatement_thenSaveIt() {
        // arrange
        Statement statement = new Statement(Operation.DEPOSIT, LocalDateTime.now(), 100L, 100L);
        // act
        Statement savedStatement = accountService.saveStatement(statement);
        // assert
        assertNotNull(savedStatement);
        assertThat(savedStatement.getOperation()).isEqualTo(Operation.DEPOSIT);
        assertThat(savedStatement.getAmount()).isEqualTo(100L);
        assertThat(savedStatement.getBalance()).isEqualTo(100L);
    }

    @Test
    void shouldGetStatements_thenReturnAccountStatements() {
        // arrange

        // act
        List<Statement> result = accountService.getStatements();
        // assert
        assertThat(result.isEmpty()).isFalse();
        assertThat(result.get(0).getOperation()).isEqualTo(Operation.DEPOSIT);
        assertThat(result.get(0).getAmount()).isEqualTo(100L);
    }

}
