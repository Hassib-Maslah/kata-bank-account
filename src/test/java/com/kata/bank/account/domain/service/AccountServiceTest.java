package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.enums.Operation;
import com.kata.bank.account.domain.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        long amount = 100;
        // act
        boolean result = accountService.makeDeposit(amount);
        // assert
        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(200L);
    }

    @Test
    void shouldMakeWithdrawal_thenReturnTrue() {
        // arrange
        long amount = 50;
        // act
        boolean result = accountService.makeWithdrawal(amount);
        // assert
        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(amount);
    }

    @Test
    void shouldNotMakeWithdrawal_thenReturnFalse() {
        // arrange
        long amount = 500;
        // act
        boolean result = accountService.makeWithdrawal(amount);
        // assert
        assertThat(result).isFalse();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(100L);
    }

    @Test
    void shouldCreateStatement_thenSaveIt() {
        // arrange

        // act
        Statement savedStatement = accountService.saveStatement(100L, 100L, Operation.DEPOSIT);
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
