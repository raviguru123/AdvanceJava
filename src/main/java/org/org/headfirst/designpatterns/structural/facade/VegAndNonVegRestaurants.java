package org.org.headfirst.designpatterns.structural.facade;

public class VegAndNonVegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new Both();
    }
}
