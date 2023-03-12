package org.lld.practice.navi.ledger.co.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.lld.practice.navi.ledger.co.exception.InvalidCommand;

@Builder
@Getter
@Setter
public class PaymentCommand {
    String bank_name;
    String borrower_name;

    double amount;
    int emi_no;

    public static PaymentCommand parse(String command) throws Exception {
        String[] arr = command.split(" ");
        if (arr.length != 5) {
            throw new InvalidCommand("invalid Payment Command");
        }

        return PaymentCommand.builder().bank_name(arr[1])
                .borrower_name(arr[2])
                .amount(Double.parseDouble(arr[3]))
                .emi_no(Integer.parseInt(arr[4]))
                .build();
    }
}
