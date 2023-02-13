package org.lld.practice.coffee.maker;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

//Coffee Maker
//        Description
//        Can you design a coffee maker, that take a coffee pack, and can simply make a cup of coffee.
//        Coffee pack contains the recipe of the coffee, like how many milk / how many sugar to be added in the coffee
//        Coffee maker can make coffee based on the recipe provided by the coffee pack
//        Only consider 2 type of ingredients: sugar and milk
//        the cost of Plain coffee is 2. Add one portion of milk/sugar will increase the cost by 0.5
//        Consider use decorator design pattern
//https://aaronice.gitbook.io/object-oriented-design/ood-case-studies/coffee-maker
public class Driver {
    public static void main(String[] args) {
        CoffeePack coffeePack = new CoffeePack(2, 3);
        Coffee coffee = new SimpleCoffee();

        for (int i = 0; i < coffeePack.getMilk(); i++) {
            coffee = new Milk(coffee);
        }

        for (int i = 0; i < coffeePack.getSugar(); i++) {
            coffee = new Sugar(coffee);
        }

        System.out.println("Total Cost of coffee : " + coffee.getCost());
        System.out.println("description of the coffee : " + coffee.getDescription());
    }
}
