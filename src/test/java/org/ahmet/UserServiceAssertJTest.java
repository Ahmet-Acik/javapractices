package org.ahmet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceAssertJTest {

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

        assertThat(user.getPurchases()).hasSize(1).contains(product);
    }

    @Test
    public void testUpdateUserEmail() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());

        userService.updateUserEmail(user, "john.new@example.com");

        assertThat(user.getEmail()).isEqualTo("john.new@example.com");
    }

    @Test
    public void testGetOrderStatus() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product productLaptop = new Product(1, "Laptop", 999.99, "Electronics");

        // Add the product to the user's purchases
        userService.addUserPurchase(user, productLaptop);

        // Verify the product is added
        assertTrue(user.getPurchases().contains(productLaptop), "Product should be in the user's purchases");

        OrderStatus status = userService.getOrderStatus(user, productLaptop);

        assertEquals(OrderStatus.PENDING, status);
    }
}