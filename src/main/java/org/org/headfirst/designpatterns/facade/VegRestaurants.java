package org.org.headfirst.designpatterns.facade;

public class VegRestaurants implements  Restaurants{
    public Menu getMenu() {
        return new VegMenu();
    }
}
