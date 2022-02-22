package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.WithdrawRequest;

public interface AccountService {

    boolean makeDeposit(DepositRequest depositRequest);

    boolean makeWithdrawal(WithdrawRequest withdrawRequest);

    Account getAccount();

    Account saveAccount(Account account);

}
