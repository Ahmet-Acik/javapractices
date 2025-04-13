package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollecting {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> collectedList = list.stream()
                .collect(Collectors.toList());
        System.out.println(collectedList); // Output: [apple, banana, cherry]

        // Example with User class

        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        List<String> collectedUsers = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(collectedUsers); // Output: [Alice, Bob, Charlie]

        // Example with User class and custom collecting
        List<String> collectedUsersWithCustom = users.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
        System.out.println(collectedUsersWithCustom);

        // Example with User class and custom collecting to a set
        Set<String> collectedUsersToSet = users.stream()
                .map(User::getEmail)
                .collect(Collectors.toSet());
//                .stream()
//                .collect(Collectors.toList());
        System.out.println(collectedUsersToSet);

        // Example with User class and custom collecting to a set with filtering
        Set<String> collectedUsersToSetWithFilter = users.stream()
                .filter(user -> user.getAge() > 21)
                .map(User::getEmail)
                .collect(Collectors.toSet());



    }
}