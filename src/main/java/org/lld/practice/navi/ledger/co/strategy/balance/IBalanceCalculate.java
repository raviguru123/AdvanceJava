package org.lld.practice.navi.ledger.co.strategy.balance;

import org.lld.practice.navi.ledger.co.Loan;
import org.lld.practice.navi.ledger.co.command.BalanceCommand;

public interface IBalanceCalculate {
    public String calculate(Loan loan, BalanceCommand balanceCommand);
}
