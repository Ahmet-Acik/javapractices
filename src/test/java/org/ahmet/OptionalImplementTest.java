package org.ahmet;

import org.ahmet.optional_Impl.OptionalImplement;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalImplementTest {

    @Test
    public void testOptionalOfNullableWithNull() {
        String value = null;
        String result = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Default Value", result);
    }

    @Test
    public void testOptionalOfNullableWithNonNull() {
        String value = "Hello";
        String result = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Hello", result);
    }

    @Test
    public void testOptionalOrElseGetWithMethodReference() {
        String value = null;
        String result = Optional.ofNullable(value).orElseGet(OptionalImplement::getDefaultValue);
        assertEquals("Default Value", result);
    }

    @Test
    public void testOptionalIfPresent() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.ofNullable(value);
        optionalValue.ifPresent(val -> assertEquals("Hello", val));
    }

    @Test
    public void testOptionalOrElseThrow() {
        String value = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Optional.ofNullable(value).orElseThrow(() -> new IllegalArgumentException("Value cannot be null"));
        });
    }

    @Test
    public void testOptionalMap() {
        String value = "hello";
        String result = Optional.ofNullable(value).map(String::toUpperCase).orElse("Default Value");
        assertEquals("HELLO", result);
    }

    @Test
    public void testOptionalFlatMap() {
        Optional<String> optionalString = Optional.of("hello");
        Optional<String> optionalUpperCase = optionalString.flatMap(val -> Optional.of(val.toUpperCase()));
        assertTrue(optionalUpperCase.isPresent());
        assertEquals("HELLO", optionalUpperCase.get());
    }

    @Test
    public void testOptionalFilter() {
        Optional<String> filteredValue = Optional.of("hello").filter(val -> val.startsWith("h"));
        assertTrue(filteredValue.isPresent());
        assertEquals("hello", filteredValue.get());
    }

    @Test
    public void testOptionalIsPresent() {
        String value = null;
        boolean isPresent = Optional.ofNullable(value).isPresent();
        assertFalse(isPresent);
    }

    @Test
    public void testOptionalOrElse() {
        String value = null;
        String defaultValue = Optional.ofNullable(value).orElse("Default Value");
        assertEquals("Default Value", defaultValue);
    }

    @Test
    public void testOptionalOrElseGetWithLambda() {
        String value = null;
        String orElseGetValue = Optional.ofNullable(value).orElseGet(() -> "Generated Default Value");
        assertEquals("Generated Default Value", orElseGetValue);
    }

    @Test
    public void testOptionalOrElseThrowWithCustomException() {
        String value = null;
        assertThrows(OptionalImplement.CustomException.class, () -> {
            Optional.ofNullable(value).orElseThrow(() -> new OptionalImplement.CustomException("Custom exception: Value cannot be null"));
        });
    }

    @Test
    public void testOptionalOf() {
        String value = "Hello";
        Optional<String> optionalValue = Optional.of(value);
        assertTrue(optionalValue.isPresent());
        assertEquals("Hello", optionalValue.get());
    }

}