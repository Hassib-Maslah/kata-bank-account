package com.kata.bank.account.application.request;

public class DepositRequest {

    private Long amount;

    public DepositRequest() {
    }

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
