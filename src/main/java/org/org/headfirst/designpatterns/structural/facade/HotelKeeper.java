package org.org.headfirst.designpatterns.structural.facade;

public interface HotelKeeper {
    public VegMenu getVegMenu();
    public NonVegMenu getNonVegMenu();

    public Both getBothMenu();
}
