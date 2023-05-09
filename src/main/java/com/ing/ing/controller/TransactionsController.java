package com.ing.ing.controller;

import com.ing.ing.models.Account;
import com.ing.ing.models.Transaction;
import com.ing.ing.view.TransactionsView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.SortedSet;

@RestController
@RequestMapping(path = "/transactions")
public final class TransactionsController {
    private final TransactionsView transactionsView = new TransactionsView();

    @PostMapping("/report")
    public SortedSet<Account> Report(@RequestBody Transaction[] transactions) {
        if (transactions.length == 0) throw new ArrayIndexOutOfBoundsException("Transactions are empty");
        return transactionsView.Report(transactions);
    }
}
