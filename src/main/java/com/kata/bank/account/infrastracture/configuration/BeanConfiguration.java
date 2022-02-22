package com.kata.bank.account.infrastracture.configuration;

import com.kata.bank.account.domain.service.AccountService;
import com.kata.bank.account.domain.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }

}
