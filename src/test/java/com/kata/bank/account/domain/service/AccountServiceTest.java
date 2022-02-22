package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.DepositRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl();
    }

    @Test
    void shouldMakeDeposit_thenReturnTrue() {
        DepositRequest depositRequest = new DepositRequest(100L);

        boolean result = accountService.makeDeposit(depositRequest);

        assertThat(result).isTrue();
        assertThat(accountService.getAccount().getAmount()).isEqualTo(100L);
    }
}
