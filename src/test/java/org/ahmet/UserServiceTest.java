package org.ahmet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private UserProcessor userProcessor;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        userProcessor = mock(UserProcessor.class);
    }

    @Test
    public void testProcessUsers() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        List<User> users = List.of(user);

        userService.processUsers(users, userProcessor);

        verify(userProcessor, times(1)).process(user);
    }

    @Test
    public void testAddUserPurchase() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product product = new Product(1, "Laptop", 999.99, "Electronics");

        userService.addUserPurchase(user, product);

        assertEquals(1, user.getPurchases().size());
        assertEquals(product, user.getPurchases().get(0));
    }

    @Test
    public void testUpdateUserEmail() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());

        userService.updateUserEmail(user, "john.new@example.com");

        assertEquals("john.new@example.com", user.getEmail());
    }

    @Test
    public void testGetOrderStatus() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product product = new Product(1, "Laptop", 999.99, "Electronics");

        OrderStatus status = userService.getOrderStatus(user, product);

        assertEquals(OrderStatus.PENDING, status);
    }
}