package org.ahmet;

import java.util.List;

public class UserService {

    public void processUsers(List<User> users, UserProcessor processor) {
        users.forEach(processor::process);
    }

    public void addUserPurchase(User user, Product product) {
        user.getPurchases().add(product);
    }

    public void updateUserEmail(User user, String newEmail) {
        user.setEmail(newEmail);
    }

    public OrderStatus getOrderStatus(User user, Product product) {
        // This is a placeholder implementation. In a real application, the order status would be retrieved from a database or another service.
        return OrderStatus.PENDING;
    }
}