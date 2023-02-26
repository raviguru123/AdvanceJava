package org.lld.practice.ticketing.system;

public enum TicketType {
    CHECK_WALLET_BALANCE("check-wallet-balance"),
    CHANGE_LANGUAGE("change-language"),

    OTHERS("others");

    public final String val;

    private TicketType(String type) {
        this.val = type;
    }
}
