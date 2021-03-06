package com.kata.bank.account;

import com.kata.bank.account.application.request.DepositRequest;
import com.kata.bank.account.application.request.WithdrawRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AccountIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void makeDeposit_returnsTrue() {
        // arrange
        DepositRequest request = new DepositRequest(100L);
        // act
        ResponseEntity<Boolean> response = testRestTemplate.postForEntity("/account-management/deposit", request, Boolean.class);
        // assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(Boolean.TRUE);
    }

    @Test
    public void makeWithdrawal_returnsTrue() {
        // arrange
        WithdrawRequest request = new WithdrawRequest(100L);
        // act
        ResponseEntity<Boolean> response = testRestTemplate.postForEntity("/account-management/withdraw", request, Boolean.class);
        // assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(Boolean.TRUE);
    }

    @Test
    public void getStatements_returnsAccountStatements() {
        // arrange

        // act
        ResponseEntity<List> response = testRestTemplate.getForEntity("/account-management/statements", List.class);
        // assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().isEmpty()).isFalse();
    }

}
