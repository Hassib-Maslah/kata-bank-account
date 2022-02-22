package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.DepositRequest;

public interface AccountService {

    boolean makeDeposit(DepositRequest depositRequest);

}
