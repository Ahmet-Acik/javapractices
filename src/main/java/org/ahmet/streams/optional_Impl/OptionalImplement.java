package org.ahmet.streams.optional_Impl;

import java.util.Optional;

public class OptionalImplement {
    public static void main(String[] args) {

        // Example of using Optional
        String value = null;
        String result = Optional.ofNullable(value)
                .orElse("Default Value");
        System.out.println(result); // Output: Default Value

        // Example of using Optional with a method reference
        String resultWithMethodReference = Optional.ofNullable(value)
                .orElseGet(OptionalImplement::getDefaultValue);
        System.out.println(resultWithMethodReference); // Output: Default Value

        // Example of using Optional with ifPresent
        Optional<String> optionalValue = Optional.ofNullable(value);
        optionalValue.ifPresent(val -> System.out.println("Value is present: " + val));
        // No output since value is null

        // Example of using Optional with orElseThrow
        try {
            String resultOrThrow = Optional.ofNullable(value)
                    .orElseThrow(() -> new IllegalArgumentException("Value cannot be null"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Value cannot be null
        }

        // Example of using Optional with map
        String upperCaseValue = Optional.ofNullable("hello")
                .map(String::toUpperCase)
                .orElse("Default Value");
        System.out.println(upperCaseValue); // Output: HELLO

        // Example of using Optional with flatMap
        Optional<String> optionalString = Optional.of("hello");
        Optional<String> optionalUpperCase = optionalString
                .flatMap(val -> Optional.of(val.toUpperCase()));
        optionalUpperCase.ifPresent(System.out::println); // Output: HELLO
    }

    private static String getDefaultValue() {
        return "Default Value";
    }
}