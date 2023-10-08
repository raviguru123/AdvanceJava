package org.lld.practice.inventory.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Builder
@Getter
@Setter
class Address {
    String street;
    String city;
    String pinCode;
    String country;
}

@AllArgsConstructor
@Getter
class Person {
    String name;
    Address address;
}


class Vendor extends Person {
    public Vendor(String name, Address address) {
        super(name, address);
    }
}

class Customer extends Person {
    public Customer(String name, Address address) {
        super(name, address);
    }
}

interface Product {
    public String getName();

    public UUID getId();

    public Category getCategory();

    public Vendor getVendor();


    public int calculateWeightage();
}

@AllArgsConstructor
@Getter
class Promotion {
    String description;
    int weight;
}

@Builder
@AllArgsConstructor
@Setter
@Getter
class ConcreteProduct implements Product {
    String name;
    UUID id;
    Category category;
    Vendor vendor;

    List<Promotion> promotions;


    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Vendor getVendor() {
        return vendor;
    }


    public int calculateWeightage() {
        int weight = 0;
        for (Promotion promotion : promotions) {
            weight += promotion.getWeight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Name : " + name + "  Vendor Name : " + vendor.name;
    }
}


class ProductDecorator implements Product {
    Product product;
    Promotion promotion;

    public ProductDecorator(Product product, Promotion promotion) {
        this.product = product;
        this.promotion = promotion;
    }

    public String getName() {
        return product.getName();
    }

    public UUID getId() {
        return product.getId();
    }

    public Category getCategory() {
        return product.getCategory();
    }

    public Vendor getVendor() {
        return product.getVendor();
    }


    public int calculateWeightage() {
        return promotion.getWeight() + product.calculateWeightage();
    }

    @Override
    public String toString() {
        return product.toString();
    }
}


class Inventory {
    private static Inventory inventory;
    Map<Product, Integer> products;

    private Inventory() {
        this.products = new HashMap<>();
    }

    public static Inventory getInstance() {
        if (inventory == null) {
            synchronized (Inventory.class) {
                if (inventory == null) {
                    inventory = new Inventory();
                }
            }
        }
        return inventory;
    }

    public void addProduct(Product product, int quantity) {
        this.products.put(product, quantity);
    }

    public boolean isAvailable(Product product, int requestedQuantity) {
        return this.products.getOrDefault(product, 0) >= requestedQuantity;
    }

    public void reduceQuantity(Product product, int quantity) {
        int currentQuantity = this.products.getOrDefault(product, 0);
        if (currentQuantity >= quantity) {
            this.products.put(product, currentQuantity - quantity);
        }
    }

    public List<Product> searchProduct(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : products.keySet()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase()) && isAvailable(product, 1)) {
                results.add(product);
            }
        }
        results.sort(Comparator.comparing(Product::calculateWeightage).reversed());
        return results;
    }
}

enum Category {
    Phone, TV
}

public class Driver {
    public static void main(String[] args) {
        Inventory inventory = Inventory.getInstance();
        Promotion promotion1 = new Promotion("Festive sell", 10);
        Promotion promotion2 = new Promotion("Diwali sell", 5);
        Promotion promotion3 = new Promotion("Paid Promotion", 6);

        Product product1 = ConcreteProduct.builder()
                .name("Redmi Note 8")
                .id(UUID.randomUUID())
                .category(Category.Phone)
                .promotions(new ArrayList<>())
                .vendor(new Vendor("Sony", Address.builder().build()))
                .build();
        product1 = new ProductDecorator(product1, promotion1);


        Product product2 = ConcreteProduct.builder()
                .name("Redmi Note 8")
                .id(UUID.randomUUID())
                .category(Category.Phone)
                .promotions(new ArrayList<>())
                .vendor(new Vendor("Redmi", Address.builder().build()))
                .build();


        product2 = new ProductDecorator(product2, promotion2);
        product2 = new ProductDecorator(product2, promotion3);


        inventory.addProduct(product1, 10);
        inventory.addProduct(product2, 10);

        List<Product> result = inventory.searchProduct("redmi");

        System.out.println(result);
    }
}
