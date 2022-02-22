package com.kata.bank.account.application.controller;

import com.kata.bank.account.application.controller.AccountController;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.service.AccountService;
import com.kata.bank.account.infrastracture.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void makeDeposit_shouldReturnsTrue() throws Exception {
        given(accountService.makeDeposit(any())).willReturn(Boolean.TRUE);

        DepositRequest request = new DepositRequest(100L);

        mockMvc.perform(post("/account-management/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Boolean.TRUE));
    }


}
