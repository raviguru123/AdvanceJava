package org.lld.practice.foodkart;


import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String, Item> itemMap = new HashMap<>();

    public void addItem(final Item item) {
        this.itemMap.put(item.getName(), item);
    }

    public Item getItem(final String name) {
        if (!this.itemMap.containsKey(name)) {
            System.out.println("Item not exist with given name" + name);
            return null;
        }
        return this.itemMap.get(name);
    }
}

