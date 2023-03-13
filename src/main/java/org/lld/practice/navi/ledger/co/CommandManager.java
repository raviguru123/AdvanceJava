package org.lld.practice.navi.ledger.co;

public class CommandManager {
    private static Ledger ledger = Ledger.getInstance();
    public static void execute(String input) {
        String[] inputSplit = input.split(" ");
        switch (inputSplit[0]) {
            case "LOAN" :
                ledger.loan(input);
                break;
            case "PAYMENT" :
                ledger.payment(input);
                break;
            case "BALANCE" :
               ledger.balance(input);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputSplit[0]);
        }
    }
}