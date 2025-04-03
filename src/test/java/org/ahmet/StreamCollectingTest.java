package org.ahmet;

import org.ahmet.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamCollectingTest {

    @Test
    public void testCollectToList() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> collectedList = list.stream().collect(Collectors.toList());
        assertEquals(Arrays.asList("apple", "banana", "cherry"), collectedList);
    }

    @Test
    public void testCollectUserNamesToList() {
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        List<String> collectedUsers = users.stream().map(User::getName).collect(Collectors.toList());
        assertEquals(Arrays.asList("Alice", "Bob", "Charlie"), collectedUsers);
    }

    @Test
    public void testCollectUserEmailsToList() {
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        List<String> collectedUsersWithCustom = users.stream().map(User::getEmail).collect(Collectors.toList());
        assertEquals(Arrays.asList("alice@example.com", "bob@example.com", "charlie@example.com"), collectedUsersWithCustom);
    }

    @Test
    public void testCollectUserEmailsToSet() {
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        Set<String> collectedUsersToSet = users.stream().map(User::getEmail).collect(Collectors.toSet());
        assertEquals(Set.of("alice@example.com", "bob@example.com", "charlie@example.com"), collectedUsersToSet);
    }
}