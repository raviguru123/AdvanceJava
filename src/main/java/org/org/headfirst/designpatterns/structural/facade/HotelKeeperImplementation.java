package org.org.headfirst.designpatterns.structural.facade;

public class HotelKeeperImplementation implements HotelKeeper {
    public VegMenu getVegMenu() {
        VegRestaurants vegRestaurants = new VegRestaurants();
        VegMenu vegMenu = (VegMenu) vegRestaurants.getMenu();
        return vegMenu;
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurants nonVegRestaurants = new NonVegRestaurants();
        NonVegMenu vegMenu = (NonVegMenu) nonVegRestaurants.getMenu();
        return vegMenu;
    }

    public Both getBothMenu() {
        VegAndNonVegRestaurants vegAndNonVegRestaurants = new VegAndNonVegRestaurants();
        Both both = (Both) vegAndNonVegRestaurants.getMenu();
        return both;
    }
}
