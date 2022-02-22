package com.kata.bank.account.domain.service.impl;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.enums.Operation;
import com.kata.bank.account.domain.service.AccountService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private Account account;
    private List<Statement> statements;

    {
        account = new Account("James", 100L);
        statements = new ArrayList<>();
        statements.add(new Statement(Operation.DEPOSIT, LocalDateTime.now(), 100L, 100L));
    }

    @Override
    public boolean makeDeposit(Long amount) {
        Account account = getAccount();
        if (account == null) {
            return false;
        }
        // sum account balance and the amount
        account.setAmount(account.getAmount() + amount);
        // persist the account
        saveAccount(account);
        // save the operation
        saveStatement(account.getAmount(), amount, Operation.DEPOSIT);

        return true;
    }

    @Override
    public boolean makeWithdrawal(Long amount) {
        Account account = getAccount();
        if (account == null) {
            return false;
        }
        // check available balance
        if (account.getAmount() < amount) {
            return false;
        }
        // sum account balance and the amount
        account.setAmount(account.getAmount() - amount);
        // persist the account
        saveAccount(account);
        // save the operation
        saveStatement(account.getAmount(), amount, Operation.WITHDRAW);

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

    @Override
    public Statement saveStatement(Long balance, Long amount, Operation operation) {
        Statement statement = new Statement(operation, LocalDateTime.now(), amount, balance);
        statements.add(statement);
        return statement;
    }

    @Override
    public List<Statement> getStatements() {
        return statements;
    }


}
