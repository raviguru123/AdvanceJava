package org.lld.practice.navi.ledger.co.models;

import lombok.NonNull;
import org.lld.practice.navi.ledger.co.exception.LoanNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    String name;
    Map<String, Loan> loanMap;

    public Bank(@NonNull final String name) {
        this.name = name;
        this.loanMap = new HashMap<>();
    }

    public void addLoan(@NonNull Loan loan) {
        this.loanMap.put(loan.borrower.getName(), loan);
    }

    public Loan getLoan(String name) throws LoanNotFoundException {
        if (!this.loanMap.containsKey(name)) {
            throw new LoanNotFoundException("Loan not found against user " + name);
        }
        return this.loanMap.get(name);
    }
}
