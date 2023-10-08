package org.org.headfirst.designpatterns.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class VegMenu implements  Menu{
    List<Item> itemList;

    public VegMenu() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }
}
