package org.lld.practice.foodkart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {

    private final String name;
    private int quantity = 0;

    private final double price;

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public boolean isAvailableQuantity(int quantity) {
        return this.quantity >= quantity;
    }
}
