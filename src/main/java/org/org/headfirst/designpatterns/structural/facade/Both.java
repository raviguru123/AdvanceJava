package org.org.headfirst.designpatterns.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class Both implements Menu {
    List<Item> itemList;

    public Both() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }
}
