package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatList); // Output: [a, b, c, d, e, f, g, h, i]

        // Example with User class
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        // Example with User class and custom flatMap
        List<String> userEmails = users.stream()
                .flatMap(user -> Arrays.stream(new String[]{user.getEmail()}))
                .collect(Collectors.toList());

        System.out.println(userEmails);

        // Example with User class and custom flatMap
        List<String> userNames = users.stream()
                .flatMap(user -> Arrays.stream(new String[]{user.getName()}))
                .collect(Collectors.toList());

        System.out.println(userNames); // Output: [Alice, Bob, Charlie]
    }
}