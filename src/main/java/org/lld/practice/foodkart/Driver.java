package org.lld.practice.foodkart;

public class Driver {
    public static void main(String[] args) throws  Exception{
        FoodCart foodCart = FoodCart.getInstance();
        foodCart.registerUser("Pralove", "M", "phoneNumber-1", "HSR");
        foodCart.registerUser("Nitesh", "M", "phoneNumber-2", "BTM");
        foodCart.registerUser("Vatsal", "M",  "phoneNumber-3", "BTM");
        foodCart.logInUser("phoneNumber-1");
        
        foodCart.registerRestaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);

        foodCart.registerRestaurant("Food Court-2", "BTM", "Burger", 120, 3);

        foodCart.logInUser("phoneNumber-2");

        foodCart.registerRestaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

        foodCart.logInUser("phoneNumber-3");

        foodCart.showRestaurant("price");
        foodCart.placeOrder("Food Court-2", 7);

        foodCart.createReview("Food Court-2", 3, "Good Food");
        foodCart.createReview("Food Court-1", 5, "Nice Food");
        foodCart.showRestaurant("rating");
        foodCart.logInUser("phoneNumber-1");

        foodCart.updateQuantity("Food Court-2", 5);

        foodCart.update_location("Food Court-2", "BTM/HSR");
    }
}
