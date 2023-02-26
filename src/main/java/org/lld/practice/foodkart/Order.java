package org.lld.practice.foodkart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.lld.practice.ticketing.system.IDGenerator;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private final int id = IDGenerator.getID();
    private final int qty;

    public Order(int qty) {
        this.qty = qty;
    }
    private Restaurants restaurants;
    private User user;

}
