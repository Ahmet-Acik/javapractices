package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPartitioningBy {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");
        Map<Boolean, List<String>> partitionedByLength = list.stream()
                                                             .collect(Collectors.partitioningBy(s -> s.length() > 5));
        System.out.println(partitionedByLength);
        // Output: {false=[apple, cherry, apricot], true=[banana]}

        // Example with User class

        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        Map<Boolean, List<User>> partitionedByAge = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() > 21));
        System.out.println(partitionedByAge);
        // Output: {false=[Bob], true=[Alice, Charlie]}

        // Example with User class and custom partitioning
        Map<Boolean, List<User>> partitionedByEmail = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getEmail().contains("example")));
        System.out.println(partitionedByEmail);
        // Output: {false=[], true=[Alice, Bob, Charlie]}

        // Example with User class and custom partitioning
        Map<Boolean, List<User>> partitionedByBirthYear = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getDateOfBirth().getYear() > 2000));
        System.out.println(partitionedByBirthYear);
        // Output: {false=[Alice, Charlie], true=[Bob]}


    }
}