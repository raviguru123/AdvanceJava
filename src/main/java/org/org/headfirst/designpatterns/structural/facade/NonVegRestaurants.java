package org.org.headfirst.designpatterns.structural.facade;

public class NonVegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new NonVegMenu();
    }
}
