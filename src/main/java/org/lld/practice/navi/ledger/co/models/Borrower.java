package org.lld.practice.navi.ledger.co.models;

import lombok.Getter;
import org.lld.practice.navi.ledger.co.models.User;

@Getter
public class Borrower extends User {
    public Borrower(final String name) {
        super(name);
    }
}
