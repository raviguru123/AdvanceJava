package org.lld.practice.navi.ledger.co.strategy.balance;

import org.lld.practice.navi.ledger.co.Loan;
import org.lld.practice.navi.ledger.co.command.BalanceCommand;

public class BalanceCalculate implements IBalanceCalculate {
    public String calculate(Loan loan, BalanceCommand balanceCommand) {
        double total_amount = loan.getPrinciple_amount() + (loan.getPrinciple_amount() * loan.getInterest_rate() * loan.getTerm()) / 100;
        double total_emi_count = Math.ceil(loan.getTerm() * 12);
        double emi_amount = Math.ceil(total_amount / total_emi_count);
        double total_paid_amount = emi_amount * balanceCommand.getEmi_no();
        int remaining_emi_count = (int) (total_emi_count - balanceCommand.getEmi_no());

        double lump_sump_amount = 0.0;
        for (int i = 1; i <= balanceCommand.getEmi_no(); i++) {
            if (loan.getLump_sum_amount().containsKey(i)) {
                total_paid_amount = total_paid_amount + loan.getLump_sum_amount().get(i);
                lump_sump_amount += loan.getLump_sum_amount().get(i);
            }
        }
        int lump_sump_emi_reduce = (int) (lump_sump_amount / emi_amount);

        return balanceCommand.getBank_name() + " " + balanceCommand.getBorrower_name() + " " + total_paid_amount + " " + (remaining_emi_count - lump_sump_emi_reduce);
    }
}
