package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Transaction {
    private String debitAccount;
    private String creditAccount;
    private double amount = 0;

    @JsonProperty("debitAccount")
    public void setDebitAccount(String debitAccount) {
        if(debitAccount.length() != 26) throw new StringIndexOutOfBoundsException("Length of debitAccount is not valid");
        this.debitAccount = debitAccount;
    }

    @JsonProperty("creditAccount")
    public void setCreditAccount(String creditAccount) {
        if(creditAccount.length() != 26) throw new StringIndexOutOfBoundsException("Length of debitAccount is not valid");
        this.creditAccount = creditAccount;
    }

    @JsonProperty("amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDebitAccount() {
        return this.debitAccount;
    }

    public String getCreditAccount() {
        return this.creditAccount;
    }

    public double getAmount() {
        return this.amount;
    }
}
