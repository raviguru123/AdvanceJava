package org.lld.practice.navi.ledger.co;

import lombok.Getter;
import lombok.Setter;
import org.lld.practice.navi.ledger.co.command.BalanceCommand;
import org.lld.practice.navi.ledger.co.command.PaymentCommand;
import org.lld.practice.navi.ledger.co.service.UserService;
import org.lld.practice.navi.ledger.co.strategy.balance.BalanceCalculate;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Loan {
    String bank_name;

    Borrower borrower;
    double principle_amount;
    int term;
    double interest_rate;

    BalanceCalculate balance_calculate;
    Map<Integer, Double> lump_sum_amount;


    public Loan(String bank_name, String borrower, double principle_amount, int term, double interest_rate, BalanceCalculate balanceCalculate) throws Exception {
        this.borrower = (Borrower) UserService.getInstance().getUser(borrower);
        this.principle_amount = principle_amount;
        this.interest_rate = interest_rate;
        this.term = term;
        this.bank_name = bank_name;
        this.balance_calculate = balanceCalculate;
        this.lump_sum_amount = new HashMap<>();
    }

    public String calculateBalance(BalanceCommand balanceCommand) {
        return balance_calculate.calculate(this, balanceCommand);
    }

    public void addLumpSumPayment(PaymentCommand paymentCommand) {
        if (!this.lump_sum_amount.containsKey(paymentCommand.getEmi_no())) {
            this.lump_sum_amount.put(paymentCommand.getEmi_no(), 0.0);
        }

        double amount = this.lump_sum_amount.get(paymentCommand.getEmi_no());
        this.lump_sum_amount.put(paymentCommand.getEmi_no(), amount + paymentCommand.getAmount());
    }
}
