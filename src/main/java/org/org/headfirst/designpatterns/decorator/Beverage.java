package org.org.headfirst.designpatterns.decorator;


public abstract class Beverage {
    String description = "uknown descriptor";

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
