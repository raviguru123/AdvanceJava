package org.lld.practice.navi.ledger.co;

import lombok.Getter;

@Getter
public abstract class User {
    String name;

    public User(final String name) {
        this.name = name;
    }
}
