package org.ahmet.streams;

import org.ahmet.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingBy {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "apricot");
        Map<Character, List<String>> groupedByFirstLetter = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(groupedByFirstLetter);
        // Output: {a=[apple, apricot], b=[banana], c=[cherry]}

        // Example with User class
        List<User> users = Arrays.asList(new User("Alice", 30, "alice@example.com", LocalDate.of(1993, 1, 1), null), new User("Bob", 20, "bob@example.com", LocalDate.of(2003, 1, 1), null), new User("Charlie", 25, "charlie@example.com", LocalDate.of(1998, 1, 1), null));
        Map<Integer, List<User>> groupedByAge = users.stream()
                .collect(Collectors.groupingBy(User::getAge));
        System.out.println(groupedByAge); // Output: {20=[Bob], 25=[Charlie], 30=[Alice]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByEmailDomain = users.stream()
                .collect(Collectors.groupingBy(user -> user.getEmail().substring(user.getEmail().indexOf("@") + 1)));
        System.out.println(groupedByEmailDomain); // Output: {example.com=[Alice, Bob, Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameInitial = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName().substring(0, 1)));
        System.out.println(groupedByNameInitial); // Output: {A=[Alice], B=[Bob], C=[Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameLength = users.stream()
                .collect(Collectors.groupingBy(user -> String.valueOf(user.getName().length())));
        System.out.println(groupedByNameLength); // Output: {3=[Bob], 5=[Alice, Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameLengthAndAge = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName().length() + "-" + user.getAge()));
        System.out.println(groupedByNameLengthAndAge); // Output: {3-20=[Bob], 5-30=[Alice], 5-25=[Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameAndEmailDomain = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName() + "-" + user.getEmail().substring(user.getEmail().indexOf("@") + 1)));
        System.out.println(groupedByNameAndEmailDomain); // Output: {Alice-example.com=[Alice], Bob-example.com=[Bob], Charlie-example.com=[Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameAndAge = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName() + "-" + user.getAge()));
        System.out.println(groupedByNameAndAge); // Output: {Alice-30=[Alice], Bob-20=[Bob], Charlie-25=[Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameAndBirthDate = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName() + "-" + user.getDateOfBirth()));
        System.out.println(groupedByNameAndBirthDate); // Output: {Alice-1993-01-01=[Alice], Bob-2003-01-01=[Bob], Charlie-1998-01-01=[Charlie]}

        // Example with User class and custom grouping
        Map<String, List<User>> groupedByNameAndBirthDateAndEmail = users.stream()
                .collect(Collectors.groupingBy(user -> user.getName() + "-" + user.getDateOfBirth() + "-" + user.getEmail()));
        System.out.println(groupedByNameAndBirthDateAndEmail);

    }
}