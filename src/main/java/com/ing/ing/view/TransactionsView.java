package com.ing.ing.view;

import com.ing.ing.models.Account;
import com.ing.ing.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public final class TransactionsView {
    private final Map<String, Account> accountHashMap = new HashMap<>();

    public SortedSet<Account> Report(Transaction[] transactions) {
        var accountsTree = new TreeSet<Account>();

        for (var transaction : transactions) {
            var debitAccount = accountHashMap.get(transaction.getDebitAccount());
            var creditAccount = accountHashMap.get(transaction.getCreditAccount());

            if (debitAccount == null) {
                debitAccount = new Account(transaction.getDebitAccount());
                accountHashMap.put(transaction.getDebitAccount(), debitAccount);
            }
            if (creditAccount == null) {
                creditAccount = new Account(transaction.getCreditAccount());
                accountHashMap.put(transaction.getCreditAccount(), creditAccount);
            }

            debitAccount.subtract(transaction.getAmount());
            creditAccount.add(transaction.getAmount());

            accountsTree.add(debitAccount);
            accountsTree.add(creditAccount);
        }

        return accountsTree;
    }
}
