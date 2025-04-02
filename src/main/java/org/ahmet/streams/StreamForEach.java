package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StreamForEach {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.stream()
            .forEach(System.out::println);

        // Example with User class
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        users.stream()
                .forEach(user -> System.out.println(user.getName())); // Output: Alice, Bob, Charlie






    }
}