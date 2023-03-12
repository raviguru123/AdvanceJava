package org.lld.practice.navi.ledger.co.exception;

import lombok.NonNull;
public class UserNotFoundException extends Exception {
    public UserNotFoundException(@NonNull final String message) {
        super(message);
    }
}