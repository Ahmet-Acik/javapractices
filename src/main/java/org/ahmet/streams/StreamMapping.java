package org.ahmet.streams;
import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapping {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<Integer> lengths = list.stream()
                                    .map(String::length)
                                    .collect(Collectors.toList());
        System.out.println(lengths); // Output: [5, 6, 6]

        // Example with User class
        List<User> users = Arrays.asList(
            new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
            new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
            new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );

        List<Integer> userAges = users.stream()
                                      .map(User::getAge)
                                      .collect(Collectors.toList());
        System.out.println(userAges); // Output: [30, 20, 25]

        // Example with User class and custom mapping
        List<String> userEmails = users.stream()
                                       .map(User::getEmail)
                                       .collect(Collectors.toList());

        System.out.println(userEmails);


    }
}