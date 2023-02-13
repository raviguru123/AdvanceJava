package org.org.headfirst.designpatterns.decorator;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        this.description = "HouseBlend description";
    }

    public double cost() {
        return 2.99;
    }
}
