package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.enums.Operation;

import java.util.List;

public interface AccountService {

    boolean makeDeposit(Long amount);

    boolean makeWithdrawal(Long amount);

    Account getAccount();

    Account saveAccount(Account account);

    Statement saveStatement(Long balance, Long amount, Operation operation);

    List<Statement> getStatements();
}
