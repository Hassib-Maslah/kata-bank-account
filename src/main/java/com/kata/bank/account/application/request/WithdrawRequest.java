package com.kata.bank.account.application.request;

public class WithdrawRequest {
    private Long amount;

    public WithdrawRequest() {
    }

    public WithdrawRequest(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
