package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StreamReducing {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = list.stream()
                      .reduce(0, Integer::sum);
        System.out.println(sum); // Output: 15

        // Example with User class
        List<User> users = Arrays.asList(
                new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null),
                new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null),
                new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null)
        );
        int totalAge = users.stream()
                            .map(User::getAge)
                            .reduce(0, Integer::sum);
        System.out.println(totalAge); // Output: 75


        // Example with User class and custom reducing
        int totalAgeWithCustomReducing = users.stream()
                .map(User::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalAgeWithCustomReducing); // Output: 75

        // Example with User class and custom reducing with initial value
        int totalAgeWithInitialValue = users.stream()
                .map(User::getAge)
                .reduce(10, (a, b) -> a + b);
        System.out.println(totalAgeWithInitialValue); // Output: 85

        // Example with User class and custom reducing with initial value and identity
        int totalAgeWithIdentity = users.stream()
                .map(User::getAge)
                .reduce(10, Integer::sum);
        System.out.println(totalAgeWithIdentity); // Output: 85

        // Example with User class and custom reducing with initial value and identity
        int totalAgeWithIdentityAndCombiner = users.stream()
                .map(User::getAge)
                .reduce(10, (a, b) -> a + b, Integer::sum);
        System.out.println(totalAgeWithIdentityAndCombiner); // Output: 85

    }
}