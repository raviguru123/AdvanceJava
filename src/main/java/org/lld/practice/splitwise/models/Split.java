package org.lld.practice.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {
    User user;

    double amount;

    public Split(User user) {
        this.user = user;
    }
}
