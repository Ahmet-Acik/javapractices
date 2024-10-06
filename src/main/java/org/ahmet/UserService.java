package org.ahmet;

import java.util.List;

public class UserService {

    public void processUsers(List<User> users, UserProcessor processor) {
        users.forEach(processor::process);
    }

    public void addUserPurchase(User user, Product product) {
        if (product == null) {
            throw new NullPointerException("Product cannot be null");
        }
        user.getPurchases().add(product);
    }

    public void updateUserEmail(User user, String newEmail) {
        user.setEmail(newEmail);
    }

    public OrderStatus getOrderStatus(User user, Product product) {
        System.out.println("Checking order status for product: " + product);
        boolean productExists = user.getPurchases().contains(product);
        System.out.println("Product exists: " + productExists);
        return productExists ? OrderStatus.PENDING : OrderStatus.NOT_FOUND;
    }
}