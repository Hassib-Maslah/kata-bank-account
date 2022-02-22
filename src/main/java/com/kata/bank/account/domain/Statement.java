package com.kata.bank.account.domain;

import com.kata.bank.account.domain.enums.Operation;

import java.time.LocalDateTime;

public class Statement {

    private Operation operation;

    private LocalDateTime timestamp;

    private Long amount;

    private Long balance;

    public Statement() {
    }

    public Statement(Operation operation, LocalDateTime timestamp, Long amount, Long balance) {
        this.operation = operation;
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
                "operation=" + operation +
                ", date=" + timestamp +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
