package com.kata.bank.account.domain.service;

import com.kata.bank.account.domain.Account;
import com.kata.bank.account.domain.DepositRequest;
import com.kata.bank.account.domain.Statement;
import com.kata.bank.account.domain.WithdrawRequest;
import com.kata.bank.account.domain.enums.Operation;

import java.util.List;

public interface AccountService {

    boolean makeDeposit(DepositRequest depositRequest);

    boolean makeWithdrawal(WithdrawRequest withdrawRequest);

    Account getAccount();

    Account saveAccount(Account account);

    Statement saveStatement(Long balance, Long amount, Operation operation);

    List<Statement> getStatements();
}
