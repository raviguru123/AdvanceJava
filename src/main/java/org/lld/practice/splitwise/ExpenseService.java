package org.lld.practice.splitwise;

import org.lld.practice.splitwise.models.*;

import java.util.List;

public class ExpenseService {
    public ExpenseService() {

    }

    public static Expense getExpenseType(ExpenseType expenseType, User paidBy, double amount, List<Split> splitList) {
        switch (expenseType) {
            case EQUAL:
                int totalUsers = splitList.size();
                double splitAmount = amount / totalUsers;
                for (Split split : splitList) {
                    split.setAmount(splitAmount);
                }
                return new EqualExpense(paidBy, amount, splitList);

            case EXACT:
                return new ExactExpense(paidBy, amount, splitList);


            case PERCENT:
                for (Split split : splitList) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    double percent = percentSplit.getPercent();
                    double splitAmount1 = (amount * percent) / 100;
                    percentSplit.setAmount(splitAmount1);

                }
                return new PercentExpense(paidBy, amount, splitList);

            default:
                return null;
        }
    }
}
