package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.parallelStream()
            .forEach(System.out::println);

        // Example with User class
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        users.parallelStream()
                .forEach(user -> System.out.println(user.getName())); // Output: Alice, Bob, Charlie

        // Example with User class and custom parallel stream

        users.parallelStream()
                .filter(user -> user.getAge() > 21)
                .forEach(user -> System.out.println(user.getName())); // Output: Alice, Charlie


        // Example with User class and custom parallel stream with map
        users.parallelStream()
                .map(user -> user.getName().toUpperCase())
                .forEach(System.out::println); // Output: ALICE, BOB, CHARLIE

        // Example with User class and custom parallel stream with filter and map

        users.parallelStream()
                .filter(user -> user.getAge() > 21)
                .map(user -> user.getName().toLowerCase())
                .forEach(System.out::println); // Output: alice, charlie

        // Example with User class and custom parallel stream with filter, map, and collect

        List<String> userNames = users.parallelStream()
                .filter(user -> user.getAge() > 21)
                .map(User::getName)
                .toList(); // Output: [Alice, Charlie]




    }
}