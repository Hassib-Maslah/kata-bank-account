package com.kata.bank.account;

import com.kata.bank.account.application.controller.AccountController;
import com.kata.bank.account.domain.model.DepositRequest;
import com.kata.bank.account.infrastracture.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void makeDeposit_shouldReturnsTrue() throws Exception {
        DepositRequest request = new DepositRequest(100L);

        mockMvc.perform(post("/account-management/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Boolean.TRUE));
    }


}
