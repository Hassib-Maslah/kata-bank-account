package com.kata.bank.account.domain.service.impl;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private static Account account;

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
    public Account getAccount() {
        return account;
    }

    @Override
    public Account saveAccount(Account accountToSave) {
        account = accountToSave;
        return account;
    }

}
