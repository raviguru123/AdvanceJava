package org.lld.practice.navi.ledger.co.exception;

import lombok.NonNull;

public class UserTypeNotExist extends Exception {
    public UserTypeNotExist(@NonNull final String message) {
        super(message);
    }
}