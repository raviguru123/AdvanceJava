package org.lld.practice.foodkart;

import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lld.practice.ticketing.system.IDGenerator;

import java.util.ArrayList;
import java.util.List;


@Getter
public class User {
    private final int id;
    private final String name;
    private final String phone_number;
    private final String gender;

    private final String pin_code;

    public User(String name, String gender, String phoneNumber, String pincode) {
        this.id = IDGenerator.getID();
        this.name = name;
        this.phone_number = phoneNumber;
        this.gender = gender;
        this.pin_code = pincode;
    }

    List<Restaurants> restaurantsList = new ArrayList<>();

    List<Order> orderList = new ArrayList<>();

    List<Ratings> ratingsList = new ArrayList<>();

    public void addRestaurants(Restaurants restaurants) {
        this.restaurantsList.add(restaurants);
    }

    public void addOrder(Order order) {
        order.setUser(this);
        this.orderList.add(order);
    }

    public void addRating(Ratings ratings) {
        ratings.setUser(this);
        this.ratingsList.add(ratings);
    }

    @Override
    public String toString() {
        return  this.name;
    }
}
