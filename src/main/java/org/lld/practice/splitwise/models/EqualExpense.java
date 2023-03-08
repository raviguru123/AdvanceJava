package org.lld.practice.splitwise.models;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(User paidBy, double amount, List<Split> splitList) {
        super(paidBy, amount, splitList);
    }

    public boolean validate() {
        return true;
    }
}
