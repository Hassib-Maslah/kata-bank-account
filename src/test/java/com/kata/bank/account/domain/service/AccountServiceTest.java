package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Account account = new Account("Jordan", 150L);

        Account savedAccount = accountService.saveAccount(account);

        assertNotNull(savedAccount);
        assertThat(savedAccount.getHolder()).isEqualTo("Jordan");
        assertThat(savedAccount.getAmount()).isEqualTo(150L);
    }

    @Test
    void shouldMakeDeposit_thenReturnTrue() {
        DepositRequest depositRequest = new DepositRequest(100L);

        boolean result = accountService.makeDeposit(depositRequest);

        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(100L);
    }

}
