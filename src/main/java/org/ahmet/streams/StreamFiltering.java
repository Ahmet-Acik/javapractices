package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFiltering {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredList = list.stream()
                                        .filter(s -> s.startsWith("a"))
                                        .collect(Collectors.toList());
        System.out.println(filteredList); // Output: [apple]

        // Example with User class
        List<User> users = Arrays.asList(
            new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
            new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
            new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );

        List<User> filteredUsers = users.stream()
                                        .filter(user -> user.getAge() > 21)
                                        .toList();

        filteredUsers.forEach(user -> System.out.println(user.getName())); // Output: Alice, Charlie

        // Example with User class and custom filter
        List<User> filteredUsersWithCustomFilter = users.stream()
                .filter(user -> user.getEmail().contains("example"))
                .toList();

        filteredUsersWithCustomFilter.forEach(user -> System.out.println(user.getName())); // Output: Alice, Bob, Charlie
    }
}