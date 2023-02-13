package org.org.headfirst.designpatterns.decorator;

public class Expresso extends Beverage {
    public Expresso() {
        this.description = "Expresso description";
    }

    public double cost() {
        return 1.99;
    }
}
