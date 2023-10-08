package org.org.headfirst.designpatterns.structural.decorator;

public class Driver {
    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println("Beverage Cost " + beverage.cost());
        System.out.println("Beverage Description : " + beverage.getDescription());
    }
}
