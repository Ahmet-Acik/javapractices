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

        //
    }

    private static String getDefaultValue() {
        return "Default Value";
    }

}
