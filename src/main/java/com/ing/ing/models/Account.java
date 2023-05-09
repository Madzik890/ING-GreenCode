package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Account implements Comparable<Account> {
    private String account;
    private int debitCount = 0;
    private int creditCount = 0;
    private double balance = 0;

    public Account(String account) {
        setAccount(account);
    }

    public void setAccount(String account) {
        if(account.length() != 26) throw new StringIndexOutOfBoundsException("Length of account is not valid");
        this.account = account;
    }
    public void setDebitCount(int debitCount) {
        this.debitCount = debitCount;
    }
    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @JsonProperty("account")
    public String getAccount() {
        return this.account;
    }
    @JsonProperty("debitCount")
    public int getDebitCount() {
        return this.debitCount;
    }
    @JsonProperty("creditCount")
    public int getCreditCount() {
        return this.creditCount;
    }
    @JsonProperty("balance")
    public double getBalance() {
        return this.balance;
    }

    public void add(double balance) {
        this.balance += balance;
        this.creditCount++;
    }
    public void subtract(double balance) {
        this.balance -= balance;
        this.debitCount++;
    }

    public int compareTo(Account p) {
        return account.compareTo(p.account);
    }
}
