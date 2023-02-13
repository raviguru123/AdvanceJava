package org.org.headfirst.designpatterns.facade;

import java.lang.reflect.Member;

public interface HotelKeeper {
    public VegMenu getVegMenu();
    public NonVegMenu getNonVegMenu();

    public Both getBothMenu();
}
