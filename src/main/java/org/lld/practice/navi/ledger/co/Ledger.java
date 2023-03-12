package org.lld.practice.navi.ledger.co;

import org.lld.practice.navi.ledger.co.command.BalanceCommand;
import org.lld.practice.navi.ledger.co.command.LoanCommand;
import org.lld.practice.navi.ledger.co.command.PaymentCommand;
import org.lld.practice.navi.ledger.co.exception.InvalidInput;
import org.lld.practice.navi.ledger.co.service.UserService;
import org.lld.practice.navi.ledger.co.service.UserType;
import org.lld.practice.navi.ledger.co.strategy.balance.BalanceCalculate;

import java.util.HashMap;
import java.util.Map;

public class Ledger {

    private static Ledger ledger;
    Map<String, Bank> bankMap;
    UserService userService;

    private Ledger() {
        this.bankMap = new HashMap<>();
        this.userService = UserService.getInstance();
    }

    public static Ledger getInstance() {
        if (ledger == null) {
            synchronized (Ledger.class) {
                if (ledger == null) {
                    ledger = new Ledger();
                }
            }
        }
        return ledger;
    }


    public void loan(String command) {
        try {
            LoanCommand loanCommand = LoanCommand.parse(command);

            if (!bankMap.containsKey(loanCommand.getBank_name())) {
                bankMap.put(loanCommand.getBank_name(), new Bank(loanCommand.getBank_name()));
            }
            this.userService.upsertUser(loanCommand.getBorrower_name(), UserType.BORROWER);

            Loan loan = new Loan(loanCommand.getBank_name(), loanCommand.getBorrower_name(),
                    loanCommand.getPrinciple_amount(), loanCommand.getTerm(), loanCommand.getInterest_rate(), new BalanceCalculate());

            bankMap.get(loanCommand.getBank_name()).addLoan(loan);
        } catch (Exception ex) {
            System.out.println("Exception occur while parsing loan command : " + ex.getMessage());
        }
    }

    public void balance(String command) {
        try {
            BalanceCommand balanceCommand = BalanceCommand.parse(command);

            if (!this.bankMap.containsKey(balanceCommand.getBank_name())) {
                throw new InvalidInput("invalid input get balance");
            }

            Bank bank = this.bankMap.get(balanceCommand.getBank_name());
            Loan loan = bank.getLoan(balanceCommand.getBorrower_name());
            System.out.println(loan.calculateBalance(balanceCommand));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void payment(String command) {
        try {
            PaymentCommand paymentCommand = PaymentCommand.parse(command);
            if (!this.bankMap.containsKey(paymentCommand.getBank_name())) {
                throw new InvalidInput("invalid input get balance");
            }

            Bank bank = this.bankMap.get(paymentCommand.getBank_name());
            Loan loan = bank.getLoan(paymentCommand.getBorrower_name());
            loan.addLumpSumPayment(paymentCommand);
        } catch (Exception ex) {
            System.out.println("Exception occur while parsing loan command : " + ex.getMessage());
        }
    }

}
