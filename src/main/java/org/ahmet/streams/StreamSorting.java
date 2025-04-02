package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorting {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("banana", "apple", "cherry");
        List<String> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList); // Output: [apple, banana, cherry]

        // Example with User class
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );

        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .toList();

        sortedUsers.forEach(user -> System.out.println(user.getName())); // Output: Alice, Bob, Charlie

        // Example with User class and custom sorting
        List<User> sortedUsersWithCustomSorting = users.stream()
                .sorted((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()))
                .toList();
        sortedUsersWithCustomSorting.forEach(user -> System.out.println(user.getName())); // Output: Bob, Charlie, Alice


        // Example with User class and custom sorting by email
        List<User> sortedUsersByEmail = users.stream()
                .sorted((u1, u2) -> u1.getEmail().compareTo(u2.getEmail()))
                .toList();
        sortedUsersByEmail.forEach(user -> System.out.println(user.getName())); // Output: Alice, Bob, Charlie
    }

}