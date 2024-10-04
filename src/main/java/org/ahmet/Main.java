package org.ahmet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product(1, "Laptop", 999.99, "Electronics");
        Product product2 = new Product(2, "Smartphone", 499.99, "Electronics");

        // Create a user with a list of purchases
        List<Product> purchases = new ArrayList<>();
        purchases.add(product1);
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), purchases);

        // Create a UserService instance
        UserService userService = new UserService();

        // Process the user
        userService.processUsers(List.of(user), u -> System.out.println("Processing user: " + u.getName()));

        // Add a new purchase to the user
        userService.addUserPurchase(user, product2);

        // Update the user's email
        userService.updateUserEmail(user, "john.new@example.com");

        // Get the order status of a product
        OrderStatus status = userService.getOrderStatus(user, product1);
        System.out.println("Order status for product1: " + status);
    }
}