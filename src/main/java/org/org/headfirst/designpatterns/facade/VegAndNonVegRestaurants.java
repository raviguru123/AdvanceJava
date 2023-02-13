package org.org.headfirst.designpatterns.facade;

public class VegAndNonVegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new Both();
    }
}
