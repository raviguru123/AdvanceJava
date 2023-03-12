package org.lld.practice.navi.ledger.co.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.lld.practice.navi.ledger.co.exception.InvalidCommand;


@Builder
@Getter
@Setter
public class LoanCommand {
    String bank_name;

    String borrower_name;
    double principle_amount;
    int term;
    double interest_rate;

    public static LoanCommand parse(String command) throws Exception {
        String[] arr = command.split(" ");

        if (arr.length != 6) {
            throw new InvalidCommand("invalid Loan Command");
        }

        return LoanCommand.builder().bank_name(arr[1])
                .borrower_name(arr[2])
                .principle_amount(Double.parseDouble(arr[3]))
                .term(Integer.parseInt(arr[4]))
                .interest_rate(Double.parseDouble(arr[5])).build();
    }
}
