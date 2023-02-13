package org.lld.practice.coffee.maker;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sugar implements Coffee {
    private final Coffee coffee;

    public double getCost() {
        return 0.5 + coffee.getCost();
    }

    public String getDescription() {
        return "Sugar : " + coffee.getDescription();
    }
}
