package org.lld.practice.navi.ledger.co.exception;

import lombok.NonNull;

public class LoanNotFoundException extends Exception {
    public LoanNotFoundException(@NonNull final String message) {
        super(message);
    }
}
