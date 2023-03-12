package org.lld.practice.navi.ledger.co.exception;

import lombok.NonNull;

public class InvalidCommand extends Exception{
    public InvalidCommand(@NonNull final String message) {
        super(message);
    }
}
