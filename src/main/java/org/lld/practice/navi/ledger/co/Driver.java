package org.lld.practice.navi.ledger.co;

public class Driver {
    public static void main(String[] args) {
        Ledger ledger = Ledger.getInstance();
        ledger.loan("LOAN IDIDI Dale 10000 5 4");
        ledger.loan("LOAN MBI Harry 2000 2 2");
        ledger.balance("BALANCE IDIDI Dale 5");
        ledger.balance("BALANCE IDIDI Dale 40");
        ledger.balance("BALANCE MBI Harry 12");
        ledger.balance("BALANCE MBI Harry 0");


        System.out.println("<================================>");


        ledger.loan("LOAN IDIDI Dale 5000 1 6");
        ledger.loan("LOAN MBI Harry 10000 3 7");
        ledger.loan("LOAN UON Shelly 15000 2 9");

        ledger.payment("PAYMENT IDIDI Dale 1000 5");
        ledger.payment("PAYMENT MBI Harry 5000 10");
        ledger.payment("PAYMENT UON Shelly 7000 12");


        ledger.balance("BALANCE IDIDI Dale 3");
        ledger.balance("BALANCE IDIDI Dale 6");
        ledger.balance("BALANCE UON Shelly 12");
        ledger.balance("BALANCE MBI Harry 12");
    }
}
