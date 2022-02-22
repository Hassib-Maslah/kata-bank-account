package com.kata.bank.account.domain.model;

public class DepositRequest {

    private Long amount;

    public DepositRequest(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
