package org.lld.practice.foodkart;

import lombok.Setter;


import java.util.*;

@Setter
public class FoodCart {
    private static FoodCart foodCart;
    Map<String, User> userMap;
    Map<String, Restaurants> restaurantsMap;

    User loggedInUser;

    private FoodCart() {
        this.userMap = new HashMap<>();
        this.restaurantsMap = new HashMap<>();
    }

    public static FoodCart getInstance() {
        if (foodCart == null) {
            foodCart = new FoodCart();
        }
        return foodCart;
    }

    public void registerUser(String name, String gender, String phoneNumber, String pincode) {
        if (this.userMap.containsKey(name)) {
            System.out.println("User already exist with the given name" + name);
            return;
        }
        User user = new User(name, gender, phoneNumber, pincode);
        this.userMap.put(user.getPhone_number(), user);
    }

    public void logInUser(final String name) throws Exception {
        if (!this.userMap.containsKey(name)) {
            throw new Exception("user not exist in the system");
        }
        this.loggedInUser = this.userMap.get(name);
    }

    public void registerRestaurant(String resturant_name, String pin_codes, String item, double price, int quantity) throws Exception {
        if (this.restaurantsMap.containsKey(resturant_name)) {
            throw new Exception("restaurants with given name already exist in this system");
        }
        Restaurants restaurants = new Restaurants(resturant_name, pin_codes, item, price, quantity, this.loggedInUser);
        this.restaurantsMap.put(restaurants.getName(), restaurants);
    }

    public List<Restaurants> showRestaurant(String sortyBy) {
        List<Restaurants> restaurantsList = new ArrayList<>();
//        System.out.println(this.restaurantsMap);
        for (Map.Entry entry : this.restaurantsMap.entrySet()) {
            Restaurants restaurants = (Restaurants) entry.getValue();
            if (restaurants.isServiceable(this.loggedInUser.getPin_code(), 1)) {
                restaurantsList.add(restaurants);
            }
        }
        if (sortyBy.equals("price")) {
            restaurantsList.sort(Comparator.comparing(Restaurants::getPrice).reversed());

        }
        if (sortyBy.equals("rating")) {
            restaurantsList.sort(Comparator.comparing(Restaurants::getRatings).reversed());
        }

        for (Restaurants restaurants : restaurantsList) {
            System.out.println(restaurants);
        }
        return restaurantsList;
    }

    public void updateQuantity(String name, int qty) throws Exception {
        if (this.loggedInUser != null && this.restaurantsMap.containsKey(name)) {
            this.restaurantsMap.get(name).updateQuantity(qty, this.loggedInUser);
            return;
        }
        throw new Exception("Invalid input error or user is not owning the restaurants");
    }

    public void createReview(String restaurant_name, int rating, String comment) throws Exception {
        if (this.restaurantsMap.containsKey(restaurant_name) && this.loggedInUser != null) {
            Ratings ratings = new Ratings(rating, comment);
            Restaurants restaurants = this.restaurantsMap.get(restaurant_name);
            restaurants.addRatings(ratings);
            this.loggedInUser.addRating(ratings);
        }
    }

    public void placeOrder(String restaurant_name, int quantity) throws Exception {
        if (this.restaurantsMap.containsKey(restaurant_name) && this.restaurantsMap.get(restaurant_name).isServiceable(this.loggedInUser.getPin_code(), quantity)) {
            Order order = new Order(quantity);
            this.restaurantsMap.get(restaurant_name).addOrder(order);
            updateQuantity(restaurant_name, quantity);
            this.loggedInUser.addOrder(order);
            return;
        }
        System.out.println("Cannot place order");
    }

    public void update_location(String restaurant_name, String location) throws  Exception{
        if(!this.restaurantsMap.containsKey(restaurant_name)) {
            throw  new Exception("restaurant not exist");
        }
        Restaurants restaurants = this.restaurantsMap.get(restaurant_name);
        restaurants.updateLocation(location);
    }

}
