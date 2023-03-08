package org.lld.practice.splitwise;

import org.lld.practice.splitwise.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseManager.showBalance();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                    break;

                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splitList = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":

                            for (int i = 0; i < noOfUsers; i++) {
                                User user = expenseManager.userMap.get(commands[4 + i]);
                                Split split = new EqualSplit(user);
                                splitList.add(split);
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL, paidBy, amount, splitList);
                            break;
                        case "EXACT":

                            for (int i = 0; i < noOfUsers; i++) {
                                User user = expenseManager.userMap.get(commands[4 + i]);
                                Split split = new ExactSplit(user, Double.parseDouble(commands[5 + noOfUsers + i]));
                                splitList.add(split);
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, paidBy, amount, splitList);
                            break;
                        case "PERCENT":

                            for (int i = 0; i < noOfUsers; i++) {
                                User user = expenseManager.userMap.get(commands[4 + i]);
                                Split split = new PercentSplit(user, Double.parseDouble(commands[5 + noOfUsers + i]));
                                splitList.add(split);
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT, paidBy, amount, splitList);
                            break;
                    }
                    break;


            }
        }

    }
}
