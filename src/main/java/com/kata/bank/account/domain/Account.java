package com.kata.bank.account.domain;

public class Account {

    private String holder;

    private Long amount;

    public Account() {}

    public Account(String holder, Long amount) {
        this.holder = holder;
        this.amount = amount;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
