package org.lld.practice.coffee.maker;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Milk implements Coffee {
    private final Coffee coffee;

    public double getCost() {
        return 0.5 + coffee.getCost();
    }

    public String getDescription() {
        return "Milk : " + coffee.getDescription();
    }
}
