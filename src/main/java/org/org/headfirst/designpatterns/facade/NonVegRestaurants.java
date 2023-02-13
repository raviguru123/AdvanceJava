package org.org.headfirst.designpatterns.facade;

public class NonVegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new NonVegMenu();
    }
}
