package org.lld.practice.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Expense {
    User paidBy;
    double amount;
    List<Split> splitList;

    public Expense(User paidBy, double amount, List<Split> splitList) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitList = splitList;
    }


    public abstract boolean validate();
}
