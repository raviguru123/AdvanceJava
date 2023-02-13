package org.org.headfirst.designpatterns.facade;

import java.util.ArrayList;
import java.util.List;

public class NonVegMenu implements Menu {
    List<Item> itemList;

    public NonVegMenu() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }
}
