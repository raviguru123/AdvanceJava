package org.lld.practice.navi.ledger.co.exception;

import lombok.NonNull;

public class InvalidInput extends Exception {
    public InvalidInput(@NonNull final String message) {
        super(message);
    }
}
