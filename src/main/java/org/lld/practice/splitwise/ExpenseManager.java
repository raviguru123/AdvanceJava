package org.lld.practice.splitwise;

import org.lld.practice.splitwise.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    Map<String, User> userMap;
    List<Expense> expenseList;
    Map<String, Map<String, Double>> balanceSheet;

    Map<String, Group> groupMap;

    public ExpenseManager() {
        this.userMap = new HashMap<>();
        this.expenseList = new ArrayList<>();
        this.balanceSheet = new HashMap<>();
        this.groupMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addGroup(Group group) {
        this.groupMap.put(group.getName(), group);
    }

    public void addUserToGroup(String groupName, String userid) {
        User user = this.userMap.get(userid);
        Group group = this.groupMap.get(groupName);
        group.addUser(user);
    }

    public void addExpense(ExpenseType expenseType, String paidBy, double amount, List<Split> splitList) {
        Expense expense = ExpenseService.getExpenseType(expenseType, userMap.get(paidBy), amount, splitList);

        this.expenseList.add(expense);

        Map<String, Double> paidUserBalanceSheet = balanceSheet.get(paidBy);

        for (Split split : expense.getSplitList()) {
            String paidTo = split.getUser().getId();

            if (!paidUserBalanceSheet.containsKey(paidTo)) {
                paidUserBalanceSheet.put(paidTo, 0.0);
            }

            paidUserBalanceSheet.put(paidTo, paidUserBalanceSheet.get(paidTo) + split.getAmount());
            Map<String, Double> balances = balanceSheet.get(paidTo);

            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());

        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        Map<String, Double> balances = this.balanceSheet.get(userId);
        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            if (entry.getValue() != 0.0) {
                isEmpty = false;
                printBalance(userId, entry.getKey(), entry.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalance() {
        for (Map.Entry<String, Map<String, Double>> entry : this.balanceSheet.entrySet()) {
            showBalance(entry.getKey());
        }
    }

    public void printBalance(String user1, String user2, double amount) {
        String userName1 = this.userMap.get(user1).getName();
        String userName2 = this.userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(userName1 + " Owes " + userName2 + " :" + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(userName2 + " Owes " + userName1 + " :" + Math.abs(amount));
        }
    }
}
