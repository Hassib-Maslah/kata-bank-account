package com.kata.bank.account.domain.service.impl;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.WithdrawRequest;
import com.kata.bank.account.domain.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private Account account;

    {
        account = new Account("James", 100L);
    }

    @Override
    public boolean makeDeposit(DepositRequest depositRequest) {
        Account account = getAccount();
        if (account == null) {
            return false;
        }
        // sum account balance and the amount
        account.setAmount(account.getAmount() + depositRequest.getAmount());
        // persist the account
        saveAccount(account);

        return true;
    }

    @Override
    public boolean makeWithdrawal(WithdrawRequest withdrawRequest) {
        Account account = getAccount();
        if (account == null) {
            return false;
        }
        // check available balance
        if (account.getAmount() < withdrawRequest.getAmount()) {
            return false;
        }
        // sum account balance and the amount
        account.setAmount(account.getAmount() - withdrawRequest.getAmount());
        // persist the account
        saveAccount(account);

        return true;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public Account saveAccount(Account account) {
        this.account = account;
        return this.account;
    }

}
