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
        // Create a new UserService instance
        userService = new UserService();
        // Create a mock UserProcessor
        userProcessor = mock(UserProcessor.class);
    }

    @Test
    public void testProcessUsers() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        List<User> users = List.of(user);

        // Process the users
        userService.processUsers(users, userProcessor);

        // Verify the user is processed
        verify(userProcessor, times(1)).process(user);
    }

    @Test
    public void testProcessUsersWithEmptyList() {
        List<User> users = new ArrayList<>();

        // Process the users
        userService.processUsers(users, userProcessor);

        // Verify no users are processed
        verify(userProcessor, never()).process(any(User.class));
    }

    @Test
    public void testAddUserPurchase() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product product = new Product(1, "Laptop", 999.99, "Electronics");

        // Add the product to the user's purchases
        userService.addUserPurchase(user, product);

        // Verify the product is added
        assertThat(user.getPurchases()).hasSize(1).contains(product);
    }

    @Test
    public void testAddUserPurchaseWithNullProduct() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());

        // Verify that adding a null product throws NullPointerException
        assertThatThrownBy(() -> userService.addUserPurchase(user, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Product cannot be null");
    }

    @Test
    public void testUpdateUserEmail() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());

        // Update the user's email
        userService.updateUserEmail(user, "john.new@example.com");

        // Verify the email is updated
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

        // Get the order status
        OrderStatus status = userService.getOrderStatus(user, productLaptop);

        // Verify the order status
        assertEquals(OrderStatus.PENDING, status);
    }

    @Test
    public void testGetOrderStatusForNonExistentProduct() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product productLaptop = new Product(1, "Laptop", 999.99, "Electronics");

        // Get the order status for a product not in the user's purchases
        OrderStatus status = userService.getOrderStatus(user, productLaptop);

        // Verify the order status
        assertEquals(OrderStatus.NOT_FOUND, status);
    }

    @Test
    public void testRemoveUserPurchase() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());
        Product product = new Product(1, "Laptop", 999.99, "Electronics");

        // Add the product to the user's purchases
        userService.addUserPurchase(user, product);

        // Remove the product from the user's purchases
        userService.removeUserPurchase(user, product);

        // Verify the product is removed
        assertThat(user.getPurchases()).doesNotContain(product);
    }

    @Test
    public void testRemoveUserPurchaseWithNullProduct() {
        User user = new User("John Doe", 30, "john.doe@example.com", LocalDate.of(1993, 1, 1), new ArrayList<>());

        // Verify that removing a null product throws NullPointerException
        assertThatThrownBy(() -> userService.removeUserPurchase(user, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Product cannot be null");

    }


}