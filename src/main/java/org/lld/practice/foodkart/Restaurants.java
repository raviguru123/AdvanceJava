package org.lld.practice.foodkart;

import lombok.Getter;
import org.lld.practice.ticketing.system.IDGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Restaurants {
    private final Integer id;
    private final String name;
    private Menu menu;
    private Map<String, Boolean> servicableMap;

    List<Order> orderList;

    private final String item_name;

    private final User owner;

    private final List<Ratings> ratingsList;

    public Restaurants(final String name, String pin_codes, String item_name, double price, int qty, User user) {
        this.id = IDGenerator.getID();
        this.name = name;
        this.item_name = item_name;
        Item item = new Item(item_name, qty, price);
        this.menu = new Menu();
        this.menu.addItem(item);
        this.servicableMap = new HashMap<>();
        this.ratingsList = new ArrayList<>();

        for (String pinCode : pin_codes.split("/")) {
            this.servicableMap.put(pinCode, true);
        }
        this.orderList = new ArrayList<>();
        this.owner = user;
    }

    public void addOrder(Order order) {
        order.setRestaurants(this);
        this.orderList.add(order);
    }

    public void updateLocation(String location) {
        this.servicableMap = new HashMap<>();
        for (String pinCode : location.split("/")) {
            this.servicableMap.put(pinCode, true);
        }
        print();
    }

    public boolean isServiceable(String pin_code, int qty) {
        if (!this.servicableMap.containsKey(pin_code)) {
            return false;
        }
        Item item = this.menu.getItem(item_name);
        return item.getQuantity() >= qty;
    }

    public void updateQuantity(int qty, User user) {
        if (isOwner(user)) {
            Item item = this.menu.getItem(item_name);
            item.addQuantity(qty);
        }
        print();
    }

    public void addRatings(Ratings ratings) {
        ratings.setRestaurants(this);
        this.ratingsList.add(ratings);
    }

    public boolean isOwner(User user) {
        return this.owner.getId() == user.getId();
    }

    public double getPrice() {
        Item item = this.menu.getItem(item_name);
        return item.getPrice();
    }

    public double getRatings() {
        int total_ratings = 0;
        for (Ratings ratings : this.ratingsList) {
            total_ratings += ratings.getStar();
        }
        return total_ratings / this.ratingsList.size();
    }

    @Override
    public String toString() {
        return this.name + "   " + this.menu.getItem(item_name).getName() + " " + this.menu.getItem(item_name).getPrice();
    }

    public void print() {
        System.out.println(this.name + "  " + this.servicableMap.keySet() + "  " + this.menu.getItem(item_name).getName() + "-" + this.menu.getItem(item_name).getQuantity());
    }

}
