package org.lld.practice.navi.ledger.co.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.lld.practice.navi.ledger.co.exception.InvalidCommand;

import java.util.Arrays;

@Builder
@Getter
@Setter
public class BalanceCommand {
    String bank_name;

    String borrower_name;

    Integer emi_no;

    public static BalanceCommand parse(String command) throws Exception {
        String[] arr = command.split(" ");

        if (arr.length < 4) {
            throw new InvalidCommand("invalid Loan Command");
        }
        return BalanceCommand.builder().bank_name(arr[1])
                .borrower_name(arr[2])
                .emi_no(Integer.parseInt(arr[3])).build();
    }
}
