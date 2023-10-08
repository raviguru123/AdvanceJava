package org.org.headfirst.designpatterns.structural.facade;

public class VegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new VegMenu();
    }
}
